# User Registration

Consider the following description of a system functionality:

### User Registration

- A screen allows users to insert, delete, or update user information.
- Each user has properties: name, email, address, and phone, where name and email are mandatory fields.
- Emails must be unique across all users.
- Only admin users can delete other users.

### Task:
- Describe the types of tests you would implement (e.g., unit, integration, or end-to-end tests) and explain the scenarios you would test to ensure the functionality works as expected.
- Provide examples of edge cases and how you would handle them.
- Include an example of a test case in code or pseudocode for one or more scenarios.

### Solution

Testing User Registration in Java

|Test Type|            Purpose       | Tools                                 |
|-------------|----------------------|---------------------------------------|
| Unit Test    |Validate logic in isolation| JUnit 5, Mockito, AssertJ             |
| Integration Test |Validate database/API interaction	|   Spring Boot Test, Testcontainers|                                    | 



