import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class PaymentService {
  private api = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  createPayment(payload: any) {
   
    return this.http.post(`${this.api}/payment`, payload);
  }

  getPayments() {
   
    return this.http.get(`${this.api}/payments`);
  }
}
