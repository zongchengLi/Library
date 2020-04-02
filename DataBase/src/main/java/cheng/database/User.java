package cheng.database;

/**
 * @author Li Zongcheng
 * @create 2020-04-02 14:15
 */
public class User {
    private int uid;
    private String name;
    private String password;
    
    public User() {
    }
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public User(int uid, String name, String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    public int getUid() {
        return uid;
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
