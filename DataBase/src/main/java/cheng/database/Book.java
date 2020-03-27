package cheng.database;

/**
 * @author Li Zongcheng
 * @create 2020-03-26 12:55
 */
public class Book {

    private String ISBN;        // id
    private String name;        // 图书名称
    private String publisher;   // 出版社
    private String author;      // 作者
    private double price;       // 价格
    private String about;       // 简介

    public Book() {
    }

    public Book(String ISBN, String name, String publisher, String author, double price, String about) {
        this.ISBN = ISBN;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.about = about;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN='" + ISBN + '\'' + ", name='" + name + '\'' + ", publisher='" + publisher + '\'' +
            ", author='" + author + '\'' + ", price=" + price + ", about='" + about + '\'' + '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
