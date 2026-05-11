import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<{ token: string }> {
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, { username, password }).pipe(
      tap(response => localStorage.setItem('token', response.token))
    );
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }

  getRole(): string {
    const token = this.getToken();
    if (!token) return '';
    const payload = JSON.parse(atob(token.split('.')[1]));
    const roles: { authority: string }[] = payload.roles || [];
    return roles.length > 0 ? roles[0].authority : '';
  }
}
