/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import entity.EBook;
import entity.PaperBook;

/**
 *
 * @author Alexander
 */
public interface BookInterface {
    public Book createBook(Book b);
    public Book findBook(long isbn);
    public Book deleteBook(long isbn);
    public Book updateBook(Book b, long isbn);
}
