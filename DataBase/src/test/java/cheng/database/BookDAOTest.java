package cheng.database;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Li Zongcheng
 * @create 2020-03-26 13:31
 */
class BookDAOTest {

    BookDAO bookDAO = null;


    @BeforeEach
    public void init() {
        bookDAO = new BookDAO();
    }

    @Test
    public void testSave() {
        String ISBN = "978-7-302-50736-9";
        String name = "JavaWeb应用开发基础教程";
        String publisher = "清华大学出版社";
        String author = "郭庆";
        double price = 49.00;
        String about = "高等学校计算机基础教育规划教材...";
        Book b = new Book(ISBN, name, publisher, author, price, about);
        boolean flag = bookDAO.save(b);
        if (flag) {
            System.out.println("Save Success!");
        } else {
            System.out.println("Save Fail!");
        }
    }

    @Test
    public void testQuery() {
        List<Book> L = bookDAO.query();
        for (Book x : L) {
            System.out.println(x);
        }
    }
}