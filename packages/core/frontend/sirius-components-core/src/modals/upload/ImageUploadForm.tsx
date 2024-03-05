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
import FormGroup from '@material-ui/core/FormGroup';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core';
import { FileUpload } from './FileUpload';
import { ImageUploadFormProps, LabeledFile } from './ImageUploadForm.types';

const useUploadImageModalStyle = makeStyles((theme) => ({
  form: {
    display: 'flex',
    flexDirection: 'column',
    paddingTop: theme.spacing(1),
    paddingLeft: theme.spacing(2),
    paddingRight: theme.spacing(2),
    '& > *': {
      marginBottom: theme.spacing(2),
    },
  },
}));
export const ImageUploadForm = ({ onChange, disabled, onSubmit }: ImageUploadFormProps) => {
  const classes = useUploadImageModalStyle();
  const [state, setState] = useState<LabeledFile>({ label: '', file: null });

  useEffect(() => {
    onChange(state);
  }, [state]);

  const handleFileSelected = (file: File) => {
    setState((prevState) => ({ ...prevState, file }));
  };

  const handleLabelChanged = (event) => {
    setState((prevState) => ({ ...prevState, label: event.target.value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (onSubmit) {
      onSubmit();
    }
  };

  return (
    <form onSubmit={handleSubmit} id="imageupload-form-id" encType="multipart/form-data" className={classes.form}>
      <TextField
        label="Label"
        name="label"
        value={state.label}
        placeholder="Label for the image"
        data-testid="imageupload-label"
        inputProps={{ 'data-testid': 'label-input' }}
        autoFocus={true}
        onChange={handleLabelChanged}
        disabled={disabled}
      />
      <FormGroup>
        <FileUpload disabled={disabled} onFileSelected={handleFileSelected} data-testid="imageupload-file" />
      </FormGroup>
    </form>
  );
};
