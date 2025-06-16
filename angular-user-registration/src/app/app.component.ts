import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: '<app-user-list [isAdmin]="isAdmin"></app-user-list>'
})
export class AppComponent {
  isAdmin = true; // Toggle this to test admin/non-admin delete access
}