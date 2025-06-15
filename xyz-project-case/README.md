# XYZ Case

The customer has a system called XYZ and intends to start updates split into 3 phases. The requirements for the first phase are as follows:
- Enable new data entries in the system, which will serve as input for the second phase.
- Implement functionality to create, update, delete, and search plants.
  - Plants should have the following attributes:
    - Code: Numeric only, mandatory, and unique.
    - Description: Alphanumeric, up to 10 characters, optional.
    - Only admin users can delete plants.
    - Ensure that the system prevents duplication of plant codes.
    
### Task:
Based on the above information:

- Write a use case or user story for this scenario, ensuring that it clearly addresses the requirements.
- Highlight any business rules or assumptions relevant to the solution.
- Describe any validations or security measures you would implement in the system.
- Suggest how you would test this functionality, including examples of edge cases.


## Solution


### User Story

**Title:** Admin and authorized users can manage plant records in the XYZ system.

**As** an authenticated user of the XYZ system,  
**I want to** create, update, search, and (if I am an admin) delete plant records,  
**so that** the system can collect and manage the input data needed for the next project phases.

---

### Use Cases

### Create Plant
- **Actor:** Authenticated user
- **Precondition:** User is logged into the system.
- **Flow:**
  1. User accesses the "Create Plant" form.
  2. Enters numeric, unique plant **Code** (mandatory).
  3. Optionally enters plant **Description** (max 10 alphanumeric characters).
  4. Submits the form.
  5. System validates and saves the plant.
- **Postcondition:** New plant is saved.

### Update Plant
- **Actor:** Authenticated user
- **Precondition:** Plant exists.
- **Flow:**
  1. User searches and selects a plant.
  2. Updates the **Description**.
  3. System validates and updates the plant.
- **Postcondition:** Updated plant is saved.

### Delete Plant
- **Actor:** Admin user only
- **Precondition:** Plant exists.
- **Flow:**
  1. Admin selects a plant to delete.
  2. Confirms deletion.
  3. System deletes the plant.
- **Postcondition:** Plant is removed.

### Search Plants
- **Actor:** Any authenticated user
- **Flow:**
  1. User enters search criteria (code or description).
  2. System displays matching results.

---

### Business Rules

- **BR1:** Code must be numeric, unique, and mandatory.
- **BR2:** Description is optional, alphanumeric, max 10 characters.
- **BR3:** Only Admins can delete a plant.
- **BR4:** No duplicate plant codes allowed.

---

### Assumptions

- User authentication is already implemented.
- User roles (admin/user) are defined.
- System supports database constraints for uniqueness.

---

### Validations and Security Measures

### Input Validation
- **Code:** Numeric (`^\d+$`), mandatory, unique.
- **Description:** Alphanumeric (`^[a-zA-Z0-9]{0,10}$`), optional.

### Security Controls
- Role-based access for delete operation.
- Server-side validation for all fields.
- Logging actions for audit.
- Rate limiting for API calls.

---

### Testing Strategy

### Functional Test Cases

| ID | Description | Expected Result |
|----|-------------|-----------------|
| TC01 | Create plant with valid data | Success |
| TC02 | Missing code | Error |
| TC03 | Non-numeric code | Error |
| TC04 | Duplicate code | Error |
| TC05 | Description > 10 chars | Error |
| TC06 | Update description | Success |
| TC07 | Admin deletes plant | Success |
| TC08 | Non-admin deletes plant | Error |
| TC09 | Search by code/description | Success |

### Edge Cases

- Simultaneous code creation: Handle race conditions.
- Case-insensitive search.
- SQL injection in description: Prevented.

---

