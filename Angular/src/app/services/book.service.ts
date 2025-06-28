import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class BookStoreService {
  private apiUrl = "http://localhost:3000";

  constructor(private http: HttpClient) {}

  getBooks(): Observable<any> {
    return this.http.get(`${this.apiUrl}/books`);
  }

  getAccessories(): Observable<any> {
    return this.http.get(`${this.apiUrl}/accessories`);
  }

  addToCart(accessory: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/cart`, accessory);
  }
}
