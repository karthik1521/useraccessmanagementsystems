import { Component} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [NgIf,NgModel],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';
  loginError: boolean = false;

  constructor(private authService: AuthService, private router: Router) {}
  
  onSubmit(): void {
    // Call AuthService to authenticate the user
    this.authService.login(this.username, this.password).subscribe({
      next: (response) => {
        if (response.success) {
          // Navigate to the dashboard on successful login
          this.router.navigate(['/dashboard']);
        } else {
          // Show an error message if login fails
          this.loginError = true;
        }
      },
      error: () => {
        // Set loginError to true if an error occurs during login
        this.loginError = true;}

  });
  }

}
