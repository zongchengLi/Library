package cheng.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Zongcheng
 * @create 2020-03-26 12:59
 */
public class BookDAO {
    
    private Connection conn;
    
    public BookDAO() {
        conn = DataBaseConnectionPool.getConnectionPool();
    }
    
    // 添加图书信息 返回true/false
    public boolean save(Book b) {
        String save_sql = "CALL sp_save_book(?,?,?,?,?,?);";
        try {
            CallableStatement stmt = conn.prepareCall(save_sql);
            stmt.setString(1, b.getISBN());
            stmt.setString(2, b.getName());
            stmt.setString(3, b.getPublisher());
            stmt.setString(4, b.getAuthor());
            stmt.setDouble(5, b.getPrice());
            stmt.setString(6, b.getAbout());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 显示已有图书 返回List<Book>
    public List<Book> query() {
        List<Book> L = new ArrayList<>();
        String query_sql = "CALL sp_query_book();";
        try {
            CallableStatement stmt = conn.prepareCall(query_sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                L.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6)));
            }
            return L;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 基于ISBN 查询 t_book表的图书信息
    public Book selectBookByISBN(String ISBN) {
        Book book = null;
        String sql = "CALL sp_select_book_by_ISBN(?);";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, ISBN);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                book = new Book(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDouble(5), rs.getString(6));
            }
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 基于ISBN 删除 t_book表的图书信息
    public boolean deleteBookByISBN(String ISBN) {
        String sql = "CALL sp_delete_book_by_ISBN(?);";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, ISBN);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 基于ISBN 更新 t_book表的图书信息
    public boolean updateBookByISBN(Book book) {
        String sql = "CALL sp_update_book_by_ISBN(?,?,?,?,?,?);";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, book.getISBN());
            stmt.setString(2, book.getName());
            stmt.setString(3, book.getPublisher());
            stmt.setString(4, book.getAuthor());
            stmt.setDouble(5, book.getPrice());
            stmt.setString(6, book.getAbout());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
