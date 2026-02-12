import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { PaymentService } from '../services/payment';

@Component({
  selector: 'app-payment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './payment-form.html',
  styleUrls: ['./payment-form.css']
})
export class PaymentFormComponent implements OnInit {
  loading = false;
  successMsg = '';
  errorMsg = '';
  fieldErrors: Record<string, string> = {};
  paymentForm: any;

  constructor(private fb: FormBuilder, private paymentService: PaymentService) {}

  ngOnInit() {
    this.paymentForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50), Validators.pattern(/^[A-Za-z ]+$/)]],
      email: ['', [Validators.required, Validators.email]],
      contact: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      amount: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{2})$/)]],
    });
  }

  get f() { return this.paymentForm.controls; }

  submit() {
    this.successMsg = '';
    this.errorMsg = '';
    this.fieldErrors = {};

    if (this.paymentForm.invalid) {
      this.paymentForm.markAllAsTouched();
      this.errorMsg = 'Please fix the validation errors.';
      return;
    }

    this.loading = true;
    this.paymentService.createPayment(this.paymentForm.value).subscribe({
      next: (res: any) => {
        this.loading = false;
        this.successMsg = res?.message || 'Payment processed successfully';
        this.paymentForm.reset();
      },
      error: (err) => {
        this.loading = false;
        if (err?.error?.errors) {
          this.fieldErrors = err.error.errors;
          this.errorMsg = 'Please correct the highlighted fields.';
        } else {
          this.errorMsg = err?.error?.message || 'Something went wrong.';
        }
      }
    });
  }
}
