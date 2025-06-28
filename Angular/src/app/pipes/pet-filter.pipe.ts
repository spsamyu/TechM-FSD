import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: "bookFilter",
})
export class BookFilterPipe implements PipeTransform {
  transform(books: any[], genre: string): any[] {
    if (!books || !genre || genre === "All") {
      return books;
    }
    return books.filter((book) => book.genre === genre);
  }
}
