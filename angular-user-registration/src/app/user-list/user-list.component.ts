import { Component, Input } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html'
})
export class UserListComponent {
  users: User[] = [];
  selectedUser: User | null = null;
  @Input() isAdmin: boolean = false;

  constructor(private userService: UserService, private toastr: ToastrService) {
    this.refresh();
  }

  onSubmit(user: User) {
    if (user.id === 0) {
      if (!this.userService.addUser(user)) {
       this.toastr.error('Email must be unique.');
      }
    } else {
      if (!this.userService.updateUser(user)) {
        this.toastr.error('Email must be unique or user not found.');
      }
    }
    this.refresh();
  }

  onDelete(id: number) {
    if (!this.userService.deleteUser(id, this.isAdmin)) {
      this.toastr.error('Only admins can delete users.');
    }
    this.refresh();
  }

  onEdit(user: User) {
    this.selectedUser = { ...user };
  }

  refresh() {
    this.users = this.userService.getUsers();
    this.selectedUser = null;
  }
}