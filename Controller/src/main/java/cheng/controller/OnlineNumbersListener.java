package cheng.controller;

/**
 * @author Li Zongcheng
 * @create 2020-04-07 21:08
 */

import cheng.database.CountDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("online")
public class OnlineNumbersListener implements ServletContextListener, HttpSessionListener,
        ServletRequestListener {
    
    ServletContext servletContext;
    
    public OnlineNumbersListener() {
    }
    
    public void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        int onlineNumbers = 0;
        servletContext.setAttribute("onlineNumbers", onlineNumbers);
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
    
    }
    
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("会话开始：" + se.getSession().getId());
        int onlineNumbers =
                Integer.parseInt(servletContext.getAttribute("onlineNumbers").toString());
        onlineNumbers++;
        servletContext.setAttribute("onlineNumbers", onlineNumbers);
        
        // 更新历史访问人数
        CountDAO.updateCountNum();
        servletContext.setAttribute("historyNumbers", CountDAO.getCountNum());
    }
    
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("会话结束：" + se.getSession().getId());
        int onlineNumbers =
                Integer.parseInt(servletContext.getAttribute("onlineNumbers").toString());
        onlineNumbers--;
        servletContext.setAttribute("onlineNumbers", onlineNumbers);
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.println(req.getRemoteAddr());
    }
}
