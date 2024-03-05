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

import { useEffect, useState } from 'react';
import { Theme, makeStyles } from '@material-ui/core';
import { ImagePickerGalleryTabProps, ImagePickerGalleryTabState } from './ImagePickerTabs.types';
import { ImagePickerGalleryFilterBar } from './ImagePickerGalleryFilterBar';
import { ImagePickerImageCard } from './ImagePickerImageCard';
import { ImageCategoryFilter } from './ImageCategoryFilter';
import { ImageFilterCategory } from './ImageCategoryFilter.types';

const useImagePickerGalleryTabStyles = makeStyles<Theme>((theme) => ({
  root: {
    display: 'flex',
    flexDirection: 'column',
    gap: theme.spacing(2),
  },
  content: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'flex-start',
  },
  grid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 150px)',
    gap: theme.spacing(1),
  },
}));

export const ImagePickerGalleryTab = ({ images, onSelection, selection }: ImagePickerGalleryTabProps) => {
  const classes = useImagePickerGalleryTabStyles();
  const [state, setState] = useState<ImagePickerGalleryTabState>({
    filterBarText: '',
    filteredImages: [...images],
    filterCategory: ImageFilterCategory.ALL,
  });

  useEffect(() => {
    setState((prevState) => ({
      ...prevState,
      filteredImages: images.filter((img) => img.label.toLowerCase().includes(prevState.filterBarText)),
    }));
  }, [images, state.filterBarText, state.filterCategory]);

  return (
    <div className={classes.root}>
      <ImagePickerGalleryFilterBar
        text={state.filterBarText}
        onTextChange={(event) => setState((prevState) => ({ ...prevState, filterBarText: event.target.value }))}
        onTextClear={() => setState((prevState) => ({ ...prevState, filterBarText: '' }))}
      />
      <div className={classes.content}>
        <ImageCategoryFilter
          selection={state.filterCategory}
          onCategoryChange={(category) => setState((prevState) => ({ ...prevState, filterCategory: category }))}
        />
        <div style={{ height: '450px', overflowY: 'auto' }}>
          <div className={classes.grid}>
            {state.filteredImages.map((image) => (
              <ImagePickerImageCard
                key={image.id}
                image={image}
                isFavorite={null}
                isSelected={image.id === selection?.id}
                onSelect={() => onSelection(image)}
                onFavorite={() => console.log('Favorite')}
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};
