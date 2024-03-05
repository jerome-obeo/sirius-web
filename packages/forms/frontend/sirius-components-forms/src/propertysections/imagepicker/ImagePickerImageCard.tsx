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

import { ImagePickerImageCardProps } from './ImagePickerImageCard.types';
import {
  Card,
  CardActionArea,
  CardActions,
  CardMedia,
  IconButton,
  Theme,
  Typography,
  makeStyles,
} from '@material-ui/core';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import FavoriteIcon from '@material-ui/icons/Favorite';
import { useContext } from 'react';
import { ServerContext, ServerContextValue } from '@eclipse-sirius/sirius-components-core';

const useImagePickerImageCardStyles = makeStyles<Theme>((theme) => ({
  media: {
    height: '150px',
  },
  content: {
    padding: theme.spacing(1),
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  selected: {
    border: `2px solid ${theme.palette.primary.main}`,
  },
  favorite: {
    color: `${theme.palette.text.secondary}`,
  },
}));

export const ImagePickerImageCard = ({
  image,
  isSelected,
  isFavorite,
  onSelect,
  onFavorite,
}: ImagePickerImageCardProps) => {
  const classes = useImagePickerImageCardStyles();
  const { httpOrigin } = useContext<ServerContextValue>(ServerContext);

  return (
    <Card className={isSelected ? classes.selected : ''}>
      <CardActionArea onClick={() => onSelect()} data-testid={`imagepicker-gallery-${image.label}-card`}>
        <CardMedia
          className={classes.media}
          image={httpOrigin + '/api/images' + image.url}
          title={image.label}
          data-testid={`imagepicker-gallery-${image.label}-card-image`}
        />
      </CardActionArea>
      <CardActions className={classes.content}>
        <Typography
          variant="body2"
          color="textPrimary"
          component="p"
          data-testid={`imagepicker-gallery-${image.label}-card-label`}>
          {image.label}
        </Typography>
        {isFavorite !== null && (
          <IconButton
            className={classes.favorite}
            aria-label="clear"
            size="small"
            title="Favorite"
            data-testid={`imagepicker-gallery-${image.label}-card-favorite`}
            onClick={() => onFavorite(!isFavorite)}>
            (isFavorite ? <FavoriteIcon color="primary" /> : <FavoriteBorderIcon />)
          </IconButton>
        )}
      </CardActions>
    </Card>
  );
};
