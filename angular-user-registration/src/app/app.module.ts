import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './user.service';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [AppComponent, UserFormComponent, UserListComponent],
  imports: [BrowserModule, FormsModule, ReactiveFormsModule, ToastrModule.forRoot()],
  providers: [UserService],
  bootstrap: [AppComponent],
})
export class AppModule {}