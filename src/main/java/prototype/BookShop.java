package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookShop implements Cloneable {

    private String name;
    private List<Book> books = new ArrayList<>();

    public void loadBooks() {
        for ( int i =0; i<=3; i++){
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("book "+i);
            books.add(book);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
//        return super.clone();  //shallow cloning : two references for existing object
        //deep cloning
        BookShop bs = new BookShop();
        bs.setName(name);
        for (Book book : getBooks()){
            bs.getBooks().add(book);
        }
        return bs;
    }
}
