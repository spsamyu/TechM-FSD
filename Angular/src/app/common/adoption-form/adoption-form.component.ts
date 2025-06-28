import { Component, Input } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-exchange-form",
  templateUrl: "./exchange-form.component.html",
  styleUrls: ["./exchange-form.component.css"],
})
export class ExchangeFormComponent {
  @Input() book: any;

  constructor(private http: HttpClient) {}

  submitForm(formData: any) {
    const exchangeRequest = {
      bookTitle: this.book?.name,
      requesterName: formData.name,
      requesterEmail: formData.email,
      requesterPhone: formData.phone,
      message: formData.message,
    };

    this.http
      .post("http://localhost:3000/exchanges", exchangeRequest)
      .subscribe((response) => {
        alert(
          `Exchange request for "${this.book.name}" submitted successfully!`
        );
      });
  }
}
