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

import { ImageCategoryFilterProps, ImageFilterCategory } from './ImageCategoryFilter.types';
import { Tab, Tabs, Theme, makeStyles } from '@material-ui/core';

const useImageCategoryFilterStyles = makeStyles<Theme>((theme) => ({
  tabs: {
    borderRight: `1px solid ${theme.palette.divider}`,
  },
}));

export const ImageCategoryFilter = ({ selection, onCategoryChange }: ImageCategoryFilterProps) => {
  const classes = useImageCategoryFilterStyles();
  return (
    <Tabs
      orientation="vertical"
      variant="scrollable"
      value={selection}
      onChange={(_, value) => onCategoryChange(value)}
      aria-label="Vertical tabs example"
      className={classes.tabs}>
      // TODO add following tabs when it is possible
      {/* <Tab label="recents" value={ImageFilterCategory.RECENTS} />
      <Tab label="favorites" value={ImageFilterCategory.FAVORITES} /> */}
      <Tab label="all" value={ImageFilterCategory.ALL} data-testid="gallery-category-all-tab" />
    </Tabs>
  );
};
