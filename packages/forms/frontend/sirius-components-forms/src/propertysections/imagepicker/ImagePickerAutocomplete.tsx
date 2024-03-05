/*******************************************************************************
 * Copyright (c) 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import { ServerContext, ServerContextValue, getCSSColor } from '@eclipse-sirius/sirius-components-core';
import Chip from '@material-ui/core/Chip';
import IconButton from '@material-ui/core/IconButton';
import InputAdornment from '@material-ui/core/InputAdornment';
import TextField from '@material-ui/core/TextField';
import { Theme, makeStyles, useTheme } from '@material-ui/core/styles';
import AddIcon from '@material-ui/icons/Add';
import DeleteIcon from '@material-ui/icons/Delete';
import MoreHorizIcon from '@material-ui/icons/MoreHoriz';
import Autocomplete from '@material-ui/lab/Autocomplete';
import { useContext, useEffect, useState } from 'react';
import { GQLImagePickerWidgetStyle } from '../../form/FormEventFragments.types';
import { ImagePickerAutocompleteProps, ImagePickerAutocompleteState } from './ImagePickerAutocomplete.types';
import { useProjectImages } from './ImagePickerHooks';
import { GQLCustomImage } from './ImagePickerPropertySection.types';
import { getTextDecorationLineValue } from '../getTextDecorationLineValue';

const useStyles = makeStyles<Theme, GQLImagePickerWidgetStyle>((theme) => ({
  optionLabel: {
    paddingLeft: theme.spacing(0.5),
  },
  valueStyle: {
    color: ({ color }) => (color ? getCSSColor(color, theme) : undefined),
    fontSize: ({ fontSize }) => (fontSize ? fontSize : undefined),
    fontStyle: ({ italic }) => (italic ? 'italic' : 'unset'),
    fontWeight: ({ bold }) => (bold ? 'bold' : 'unset'),
    textDecorationLine: ({ underline, strikeThrough }) =>
      getTextDecorationLineValue(underline ?? null, strikeThrough ?? null),
  },
  rootChip: {
    height: '48px',
  },
  iconChip: {
    height: '40px',
    borderRadius: '10px',
  },
  endAdornmentButton: {
    position: 'absolute',
    display: 'flex',
    right: theme.spacing(2.5),
    '& > *': {
      padding: 0,
    },
  },
}));

export const ImagePickerAutocomplete = ({
  editingContextId,
  widget,
  readOnly,
  onMoreClick,
  onAddClick,
  onClearClick,
  addImage,
  removeImage,
}: ImagePickerAutocompleteProps) => {
  const props: GQLImagePickerWidgetStyle = {
    color: widget.style?.color ?? null,
    fontSize: widget.style?.fontSize ?? null,
    italic: widget.style?.italic ?? null,
    bold: widget.style?.bold ?? null,
    underline: widget.style?.underline ?? null,
    strikeThrough: widget.style?.strikeThrough ?? null,
  };
  const classes = useStyles(props);
  const theme = useTheme();
  const { httpOrigin } = useContext<ServerContextValue>(ServerContext);

  const [state, setState] = useState<ImagePickerAutocompleteState>({ open: false, options: null, values: [] });
  const [getProjectImages, projectImages] = useProjectImages(editingContextId);

  useEffect(() => {
    getProjectImages();
  }, [widget.images]);

  useEffect(() => {
    setState((prevState) => ({ ...prevState, options: projectImages, values: retrieveValues(projectImages) }));
  }, [projectImages]);

  const retrieveValues = (projectImages: GQLCustomImage[]): GQLCustomImage[] => {
    const result: GQLCustomImage[] = [];
    widget.images.forEach((imageId) => {
      const retrievedImage = projectImages.find((image) => image.id === imageId);
      if (retrievedImage) {
        result.push(retrievedImage);
      }
    });
    return result;
  };

  const getOnlyNewValueIds = (updatedValues: GQLCustomImage[]): string[] => {
    if (widget.images?.length > 0) {
      return updatedValues
        .filter((updatedValue) => widget.images.some((value) => value !== updatedValue.id))
        .map((value) => value.id);
    } else {
      return updatedValues.map((value) => value.id);
    }
  };

  const handleAutocompleteChange = (_, updatedValues: GQLCustomImage[], reason: string) => {
    if (reason === 'remove-option') {
      // search in widget.images the image that is no longer in new values
      const imageToRemoveIds = widget.images.filter((imgId) => !updatedValues.some((value) => value.id === imgId));
      if (imageToRemoveIds.length === 1) {
        removeImage(imageToRemoveIds[0]);
      }
    } else {
      const newValueIds = getOnlyNewValueIds(updatedValues);
      newValueIds.forEach((id) => addImage(id));
    }
  };

  return (
    <div>
      <Autocomplete
        data-testid={widget.label}
        multiple
        filterSelectedOptions
        disabled={readOnly || widget.readOnly}
        open={state.open}
        onOpen={() =>
          setState((prevState) => {
            return {
              ...prevState,
              open: true,
            };
          })
        }
        onClose={() =>
          setState((prevState) => {
            return {
              ...prevState,
              open: false,
            };
          })
        }
        // loading={loading}
        options={state.options || []}
        getOptionLabel={(option: GQLCustomImage) => option.label}
        getOptionSelected={(option, value) => option.id === value.id}
        value={state.values}
        freeSolo={false}
        onChange={handleAutocompleteChange}
        disableClearable
        renderTags={(value, getTagProps) =>
          value.map((option, index) => (
            <Chip
              key={index}
              classes={{ label: classes.valueStyle, root: classes.rootChip, icon: classes.iconChip }}
              label={option.label}
              data-testid={`image-${option.label}`}
              icon={<img src={httpOrigin + '/api/images' + option.url} />}
              clickable={!readOnly && !widget.readOnly}
              {...getTagProps({ index })}
            />
          ))
        }
        renderInput={(params) => (
          <TextField
            {...params}
            variant="standard"
            placeholder={'Images'}
            error={widget.diagnostics.length > 0}
            helperText={widget.diagnostics[0]?.message}
            InputProps={{
              ...params.InputProps,
              style: { paddingRight: theme.spacing(10) }, // Offset required to prevent values from being displayed below the buttons
              endAdornment: (
                <>
                  {params.InputProps.endAdornment}
                  <InputAdornment position="end" className={classes.endAdornmentButton}>
                    <IconButton
                      aria-label="edit"
                      size="small"
                      title="Edit images"
                      disabled={readOnly || widget.readOnly}
                      data-testid={`${widget.label}-more`}
                      onClick={onMoreClick}>
                      <MoreHorizIcon />
                    </IconButton>
                    <IconButton
                      aria-label="add"
                      size="small"
                      title="Add new images"
                      disabled={readOnly || widget.readOnly}
                      data-testid={`${widget.label}-add`}
                      onClick={onAddClick}>
                      <AddIcon />
                    </IconButton>
                    <IconButton
                      aria-label="clear"
                      size="small"
                      title="Clear all images"
                      disabled={readOnly || widget.readOnly}
                      data-testid={`${widget.label}-clear`}
                      onClick={onClearClick}>
                      <DeleteIcon />
                    </IconButton>
                  </InputAdornment>
                </>
              ),
            }}
          />
        )}
      />
    </div>
  );
};
