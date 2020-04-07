package cheng.database;

import org.junit.jupiter.api.Test;

/**
 * @author Li Zongcheng
 * @create 2020-04-07 21:34
 */
class CountDAOTest {
    
    @Test
    void updateCountNum() {
        CountDAO.updateCountNum();
    }
    
    @Test
    void getCountNum() {
        System.out.println(CountDAO.getCountNum());
    }
}