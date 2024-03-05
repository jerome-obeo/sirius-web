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

import { gql, useLazyQuery } from '@apollo/client';
import { useState, useEffect } from 'react';
import {
  GQLCustomImage,
  GQLGetProjectImagesQueryData,
  GQLGetProjectImagesQueryVariables,
} from './ImagePickerPropertySection.types';
import { useMultiToast } from '@eclipse-sirius/sirius-components-core';

const getProjectImagesQuery = gql`
  query projectCustomImages($projectId: ID!) {
    viewer {
      project(projectId: $projectId) {
        customImages {
          id
          label
          url
        }
      }
    }
  }
`;

export const useProjectImages = (projectId: string): [() => void, GQLCustomImage[], boolean] => {
  const { addErrorMessage } = useMultiToast();
  const [projectImages, setProjectImages] = useState<GQLCustomImage[]>([]);

  const [_getProjectImages, { loading, data, error }] = useLazyQuery<
    GQLGetProjectImagesQueryData,
    GQLGetProjectImagesQueryVariables
  >(getProjectImagesQuery);

  useEffect(() => {
    if (!loading) {
      if (error) {
        addErrorMessage('An unexpected error has occurred, please refresh the page');
      }
      if (data) {
        const {
          viewer: {
            project: { customImages },
          },
        } = data;
        setProjectImages(customImages);
      }
    }
  }, [loading, data, error]);

  const getProjectImages = () => {
    _getProjectImages({
      variables: {
        projectId,
      },
    });
  };

  return [getProjectImages, projectImages, loading];
};
