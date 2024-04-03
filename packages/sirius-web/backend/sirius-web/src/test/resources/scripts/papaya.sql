-- Sample Papaya project
INSERT INTO project (
  id,
  name,
  created_on,
  last_modified_on
) VALUES (
  'c3d7df85-e0bd-472c-aec1-c05cc88276e4',
  'Papaya Sample',
  '2024-01-01 9:42:0.000',
  '2024-01-02 9:42:0.000'
);
INSERT INTO nature (
  project_id,
  name
) VALUES (
  'c3d7df85-e0bd-472c-aec1-c05cc88276e4',
  'papaya'
);
INSERT INTO semantic_data (
  id,
  project_id,
  created_on,
  last_modified_on
) VALUES (
  'cc89c500-c27e-4968-9c67-15cf767c6ef0',
  'c3d7df85-e0bd-472c-aec1-c05cc88276e4',
  '2024-01-01 9:42:0.000',
  '2024-01-02 9:42:0.000'
);
INSERT INTO semantic_data_domain (
  semantic_data_id,
  uri
) VALUES (
  'cc89c500-c27e-4968-9c67-15cf767c6ef0',
  'domain://papaya_core'
);
INSERT INTO semantic_data_domain (
  semantic_data_id,
  uri
) VALUES (
  'cc89c500-c27e-4968-9c67-15cf767c6ef0',
  'domain://papaya_logical_architecture'
);
INSERT INTO document (
  id,
  semantic_data_id,
  name,
  content,
  created_on,
  last_modified_on
) VALUES (
  'a4495c9c-d00c-4f0e-a591-1176d102a4a1',
  'cc89c500-c27e-4968-9c67-15cf767c6ef0',
  'Papaya',
  '{"json":{"version":"1.0","encoding":"utf-8"},"ns":{"papaya_core":"domain://papaya_core","papaya_logical_architecture":"domain://papaya_logical_architecture","papaya_planning":"domain://papaya_planning"},"content":[{"id":"aa0b7b22-ade2-4148-9ee2-c5972bd72ab7","eClass":"papaya_core:Root","data":{"components":[{"id":"fad0f4c9-e668-44f3-8deb-aef0edb6ddff","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-web-domain"}},{"id":"13e0b82e-3d24-403a-bfc1-4bda81846e55","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-web-application"}},{"id":"5c313fbf-d254-4a37-962b-7817cfa18526","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-web-infrastructure"}},{"id":"e462e8ac-39d3-4ab2-b20f-ea7f0a0283d6","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-web-starter"}},{"id":"92221ad3-a0b5-4774-b941-87cda3edb772","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-web"}},{"id":"48f65c15-6655-41c8-8771-b15411b69137","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-representations","packages":[{"id":"3a380f80-2e0d-43dc-9174-f052236edaba","eClass":"papaya_logical_architecture:Package","data":{"name":"org.eclipse.sirius.components.representations","types":[{"id":"87793552-d100-4115-8e01-a5c0ffa7a557","eClass":"papaya_logical_architecture:Class","data":{"name":"IComponent"}},{"id":"5b5101d0-fb1d-43fa-bc6f-4376d4623fc8","eClass":"papaya_logical_architecture:Class","data":{"name":"IProps"}},{"id":"163a8585-7cb7-410b-8442-ca5b29f7af3d","eClass":"papaya_logical_architecture:Class","data":{"name":"IRepresentation"}},{"id":"ef16f62f-88c9-4d1c-8185-77e7ad8bc7ee","eClass":"papaya_logical_architecture:Class","data":{"name":"IRepresentationDescription"}},{"id":"3923f053-719c-4ccd-8974-4847befc6e3d","eClass":"papaya_logical_architecture:Class","data":{"name":"VariableManager"}},{"id":"82a00dcd-dd99-4b70-bb82-2a467717007f","eClass":"papaya_logical_architecture:Class","data":{"name":"BaseRenderer"}}]}}]}},{"id":"576ce0c5-d35a-4972-8a3c-5217db790c45","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-core"}},{"id":"9b5f24e4-39fd-469c-a200-91574eca0c22","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-collaborative"}},{"id":"bf69f94e-ef80-4019-9ee5-d2a09b1d7565","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-diagrams","packages":[{"id":"e738abf2-ab49-416e-902e-9865548cbfbb","eClass":"papaya_logical_architecture:Package","data":{"name":"org.eclipse.sirius.components.diagrams","types":[{"id":"8e7dd20b-6e0e-4c6d-a2b0-1b03c2edb1e2","eClass":"papaya_logical_architecture:Class","data":{"name":"Diagram"}},{"id":"5053d925-249e-414e-a77e-9d2da8829955","eClass":"papaya_logical_architecture:Class","data":{"name":"Node"}},{"id":"d0391a0f-9caa-4ca4-bcdd-26e8f4aefb85","eClass":"papaya_logical_architecture:Class","data":{"name":"Edge"}}]}},{"id":"71efa238-25cf-4869-9000-b4e93646b1cb","eClass":"papaya_logical_architecture:Package","data":{"name":"org.eclipse.sirius.components.diagrams.components","types":[{"id":"8fb02c57-7a6f-451f-81b2-c92e57c261ec","eClass":"papaya_logical_architecture:Class","data":{"name":"DiagramComponent"}},{"id":"60cc8eef-6dae-4f40-bb85-a7c76faf9d88","eClass":"papaya_logical_architecture:Class","data":{"name":"NodeComponent"}},{"id":"eeaba3fc-01ae-49ce-bb6c-1a5f8d6a0d72","eClass":"papaya_logical_architecture:Class","data":{"name":"EdgeComponent"}}]}},{"id":"724f4a5e-3856-4b3d-bad0-4c66d717503b","eClass":"papaya_logical_architecture:Package","data":{"name":"org.eclipse.sirius.components.diagrams.description","types":[{"id":"66bbb032-ebd8-48a6-aad7-0f4bb24c0edd","eClass":"papaya_logical_architecture:Class","data":{"name":"DiagramDescription"}},{"id":"a7ba387d-d226-48be-aeb5-7fdeb38b7c00","eClass":"papaya_logical_architecture:Class","data":{"name":"NodeDescription"}},{"id":"8e806118-71c3-43ca-863a-18d203b4e390","eClass":"papaya_logical_architecture:Class","data":{"name":"EdgeDescription"}}]}}]}},{"id":"1c7a30b6-268e-4b67-95ee-7e2475f4cdd0","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-collaborative-diagrams"}},{"id":"a61b291c-c976-410c-ad2a-d9139200f948","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-forms"}},{"id":"780cbc79-6f69-4734-92f1-9a4ddb6691c8","eClass":"papaya_logical_architecture:Component","data":{"name":"sirius-components-collaborative-forms"}}],"projects":[{"id":"24430514-64bc-4b78-a904-4dab25d55a09","eClass":"papaya_planning:Project","data":{"name":"Sirius Web","iterations":[{"id":"8a8e1113-b7ce-4549-a80d-91349879e3d8","eClass":"papaya_planning:Iteration","data":{"name":"2024.3.0","startDate":"2023-12-11T09:00:00.00Z","endDate":"2024-02-02T18:00:00.00Z","tasks":[{"id":"63bdd245-a042-4266-8229-99718e3b4d09","eClass":"papaya_planning:Task","data":{"name":"Improve some features of the deck","startDate":"2023-12-11T09:00:00.00Z","endDate":"2023-12-15T09:00:00.00Z","tasks":[{"id":"82473bec-3402-4b8c-9030-6551496fa521","eClass":"papaya_planning:Task","data":{"name":"Support card drag and drop","startDate":"2023-12-11T09:00:00.00Z","endDate":"2023-12-13T09:00:00.00Z"}},{"id":"9832677f-1bb4-4d77-a663-27dfb0554fe9","eClass":"papaya_planning:Task","data":{"name":"Support hide/show card","startDate":"2023-12-13T09:00:00.00Z","endDate":"2023-12-15T09:00:00.00Z"}}]}},{"id":"49ab243f-c4c8-4234-8873-524568364ed2","eClass":"papaya_planning:Task","data":{"name":"Improve some features of the gantt","startDate":"2023-12-15T09:00:00.00Z","endDate":"2023-12-20T09:00:00.00Z"}},{"id":"57bd9e84-d1c5-4b24-9b71-8ff6ed87fcb0","eClass":"papaya_planning:Task","data":{"name":"Improve some features of the portal","startDate":"2023-12-20T09:00:00.00Z","endDate":"2023-12-25T09:00:00.00Z"}}]}},{"id":"87a8edac-9b4e-40a4-9a5c-672602bf6792","eClass":"papaya_planning:Iteration","data":{"name":"2024.5.0","startDate":"2024-02-05T09:00:00.00Z","endDate":"2024-03-29T18:00:00.00Z"}}],"tasks":[{"id":"31395bb3-1e09-42a5-b450-034955c45ac2","eClass":"papaya_planning:Task","data":{"name":"Improve some features of the diagram","priority":1,"done":true}},{"id":"e6e8f081-27f5-40e3-a8ab-1e6f0f13df12","eClass":"papaya_planning:Task","data":{"name":"Improve the code of the new architecture","priority":1,"done":true}},{"id":"087a700e-c509-458d-9634-5b4132ce10e3","eClass":"papaya_planning:Task","data":{"name":"Add additional tests","priority":2}},{"id":"e1c5bd66-54c2-45f1-ae3a-99d3f039affd","eClass":"papaya_planning:Task","data":{"name":"Update the documentation","priority":3}}],"contributions":[{"id":"25ba0aea-74c0-4c2c-8b2a-beb3d53a5abc","eClass":"papaya_planning:Contribution","data":{"name":"Contribute improvements to the diagrams","done":true}},{"id":"2dd4563a-e1e2-4c23-9e7d-b327c565624c","eClass":"papaya_planning:Contribution","data":{"name":"Contribute improvements to the new architecture","done":true}},{"id":"fbf744b6-6c9b-4c8a-a959-ed90e793c9b7","eClass":"papaya_planning:Contribution","data":{"name":"Contribute additional tests"}}]}}]}}]}',
  '2024-01-01 9:42:0.000',
  '2024-01-02 9:42:0.000'
);