import { Component, OnInit } from "@angular/core";
import { BookService } from "../../services/book.service";

@Component({
  selector: "app-books",
  templateUrl: "./books.component.html",
  styleUrls: ["./books.component.css"],
})
export class BooksComponent implements OnInit {
  books: any[] = [];
  selectedBook: any = null;
  isFormOpen: boolean = false;
  bookGenre: string = "All";

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.bookService.getBooks().subscribe((data) => {
      this.books = data;
    });
  }

  openRequestForm(book: any) {
    this.selectedBook = book;
    this.isFormOpen = true;
  }

  closeRequestForm() {
    this.selectedBook = null;
    this.isFormOpen = false;
  }

  onGenreChange(genre: string) {
    this.bookGenre = genre;
  }
}
