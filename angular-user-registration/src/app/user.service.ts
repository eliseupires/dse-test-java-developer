import { Injectable } from '@angular/core';
import { User } from './models/user.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  private users: User[] = [];
  private currentId = 1;

  addUser(user: User): boolean {
    if (this.users.find(u => u.email === user.email)) {
      return false; // Duplicate email
    }
    user.id = this.currentId++;
    this.users.push(user);
    return true;
  }

  updateUser(user: User): boolean {
    const index = this.users.findIndex(u => u.id === user.id);
    if (index === -1) return false;

    const emailExists = this.users.find(
      u => u.email === user.email && u.id !== user.id
    );
    if (emailExists) return false;

    this.users[index] = user;
    return true;
  }

  deleteUser(id: number, isAdmin: boolean): boolean {
    if (!isAdmin) return false;
    this.users = this.users.filter(u => u.id !== id);
    return true;
  }

  getUsers(): User[] {
    return [...this.users];
  }
}