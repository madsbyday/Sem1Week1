package entity;

import entity.EBook;
import entity.PaperBook;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-27T11:29:33")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, EBook> eBook;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Double> price;
    public static volatile SingularAttribute<Book, Long> isbn;
    public static volatile SingularAttribute<Book, PaperBook> paperBook;
    public static volatile SingularAttribute<Book, String> title;

}