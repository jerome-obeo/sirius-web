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

export interface TableProps {
  editingContextId: string;
  representationId: string;
  table: GQLTable;
  readOnly: boolean;
  onPaginationChange?: (cursor: string | null, direction: 'PREV' | 'NEXT', size: number) => void;
}

export interface TablePaginationState {
  cursor: string | null;
  direction: 'PREV' | 'NEXT';
  size: number;
}

export interface GQLTableEventSubscription {
  tableEvent: GQLTableEventPayload;
}

export interface GQLTableEventPayload {
  __typename: string;
}

export interface GQLTableRefreshedEventPayload extends GQLTableEventPayload {
  id: string;
  table: GQLTable;
}

export interface GQLTable {
  id: string;
  targetObjectId: string;
  stripeRow: boolean;
  columns: GQLColumn[];
  lines: GQLLine[];
  paginationData: GQLPaginationData;
}

export interface GQLColumn {
  id: string;
  headerLabel: string;
  headerIconURLs: string[];
  headerIndexLabel: string;
  width: number;
  isResizable: boolean;
  hidden: boolean;
}

export interface GQLLine {
  id: string;
  targetObjectId: string;
  cells: GQLCell[];
  headerLabel: string;
  headerIconURLs: string[];
  headerIndexLabel: string;
}

export interface GQLPaginationData {
  hasPreviousPage: boolean;
  hasNextPage: boolean;
  totalRowCount: number;
}

export interface GQLCell {
  __typename: string;
  id: string;
  columnId: string;
}

export interface GQLTextfieldCell extends GQLCell {
  stringValue: string;
}

export interface GQLIconLabelCell extends GQLCell {
  label: string;
  iconURLs: string[];
}

export interface GQLCheckboxCell extends GQLCell {
  booleanValue: boolean;
}

export interface GQLSelectCell extends GQLCell {
  value: string;
  options: GQLSelectCellOption[];
}

export interface GQLMultiSelectCell extends GQLCell {
  values: string[];
  options: GQLSelectCellOption[];
}

export interface GQLSelectCellOption {
  id: string;
  label: string;
}