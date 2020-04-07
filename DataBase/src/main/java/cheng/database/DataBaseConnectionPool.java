package cheng.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Li Zongcheng
 * @create 2020-03-26 13:15
 */
public class DataBaseConnectionPool {
    private static ComboPooledDataSource dataSource = null;
    
    public static Connection getConnectionPool() {
        if (dataSource == null) {
            dataSource = new ComboPooledDataSource();
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
