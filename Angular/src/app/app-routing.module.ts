import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./pages/home/home.component";
import { BooksComponent } from "./pages/books/books.component";
import { BookAccessoriesComponent } from "./pages/book-accessories/book-accessories.component";
import { CartComponent } from "./pages/cart/cart.component";
import { LoginComponent } from "./pages/login/login.component";
import { ExchangeRequestComponent } from "./pages/exchange-request/exchange-request.component";

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "books", component: BooksComponent },
  { path: "book-accessories", component: BookAccessoriesComponent },
  { path: "cart", component: CartComponent },
  { path: "login", component: LoginComponent },
  { path: "exchange-requests", component: ExchangeRequestComponent },
  { path: "**", redirectTo: "login" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
