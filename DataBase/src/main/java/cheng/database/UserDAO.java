package cheng.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 * @author Li Zongcheng
 * @create 2020-04-02 14:17
 */
public class UserDAO {
    Connection conn = null;
    
    public UserDAO() {
        conn = DataBaseConnectionPool.getConnectionPool();
    }
    
    //    登录检验
    public boolean CheckLogin(User user) {
        String sql = "CALL sp_check_login(?,?,?);";
        
        try {
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.execute();
            return stmt.getInt(3) == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CheckLogin(String name, String psd) {
        return CheckLogin(new User(name, psd));
    }
}
