# Angular Experience

Describe your experience with Angular, including its core features and use cases. Provide an example of a practical application where you used Angular and include a code snippet demonstrating a key feature, such as component communication, data binding, or service integration.

### User Registration App (Angular)

This Angular application provides basic CRUD functionality for user registration with the following features:

## Features

- Add, update, and delete user records.
- Enforce required fields: `name` and `email`.
- Ensure `email` uniqueness.
- Restrict delete access to admin users only.

## Project Structure

- `UserService`: Handles business logic and in-memory user management.
- `UserFormComponent`: Form for creating and updating users.
- `UserListComponent`: Displays a list of users and integrates the form.
- `AppComponent`: Root component with a toggle for admin mode.

## Usage

To run the project:

```bash
npm install
ng serve
```

## Admin Access

The `AppComponent` includes an `isAdmin` flag. Set it to `false` to simulate a non-admin user.

---
A basic demonstration for Angular component interaction, form handling, and service architecture.