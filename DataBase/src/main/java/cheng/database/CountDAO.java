package cheng.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author Li Zongcheng
 * @create 2020-04-07 21:30
 */
public class CountDAO {
    
    public static boolean updateCountNum() {
        Connection conn = DataBaseConnectionPool.getConnectionPool();
        String sql = "CALL sp_update_count();";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static int getCountNum() {
        Connection conn = DataBaseConnectionPool.getConnectionPool();
        String sql = "CALL sp_get_count();";
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
