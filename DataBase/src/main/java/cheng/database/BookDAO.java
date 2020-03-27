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
                L.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
                               rs.getString(6)));
            }
            return L;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
