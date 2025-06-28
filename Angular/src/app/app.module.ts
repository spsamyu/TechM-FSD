import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { CommonComponent } from "./common/common.component";
import { HomeComponent } from "./pages/home/home.component";
import { BooksComponent } from "./pages/books/books.component";
import { BookAccessoriesComponent } from "./pages/book-accessories/book-accessories.component";
import { ExchangeFormComponent } from "./common/exchange-form/exchange-form.component";
import { CartComponent } from "./pages/cart/cart.component";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { NavbarComponent } from "./common/navbar/navbar.component";
import { BookFilterPipe } from "./pipes/book-filter.pipe";
import { CartService } from "./services/cart.service";
import { LoginComponent } from "./pages/login/login.component";
import { ExchangeRequestComponent } from "./pages/exchange-request/exchange-request.component";

@NgModule({
  declarations: [
    AppComponent,
    CommonComponent,
    HomeComponent,
    BooksComponent,
    BookAccessoriesComponent,
    ExchangeFormComponent,
    CartComponent,
    NavbarComponent,
    BookFilterPipe,
    LoginComponent,
    ExchangeRequestComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  exports: [NavbarComponent],
  providers: [CartService],
  bootstrap: [AppComponent],
})
export class AppModule {}
