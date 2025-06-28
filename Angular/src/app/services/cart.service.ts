import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { BookAccessory } from "../model/book-accessory.model";

interface CartItem {
  item: BookAccessory;
  quantity: number;
}

@Injectable({
  providedIn: "root",
})
export class CartService {
  private cart: CartItem[] = [];
  private cartSubject = new BehaviorSubject<CartItem[]>(this.cart);

  constructor() {}

  getCart() {
    return this.cartSubject.asObservable();
  }

  addToCart(item: BookAccessory) {
    if (!item.id) {
      console.error("Error: Item ID is missing", item);
      return;
    }
    const existingItem = this.cart.find(
      (cartItem) => cartItem.item.id === item.id
    );
    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      this.cart.push({ item, quantity: 1 });
    }
    this.cartSubject.next([...this.cart]);
  }

  removeFromCart(item: BookAccessory) {
    this.cart = this.cart.filter((cartItem) => cartItem.item.id !== item.id);
    this.cartSubject.next([...this.cart]);
  }

  clearCart() {
    this.cart = [];
    this.cartSubject.next([]);
  }
}
