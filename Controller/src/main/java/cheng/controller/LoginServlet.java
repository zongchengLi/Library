package cheng.controller;

import cheng.database.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Li Zongcheng
 * @create 2020-04-02 14:09
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String name = req.getParameter("name");
        boolean isSuccess = userDAO.CheckLogin(name, req.getParameter("psd"));
        HttpSession session = req.getSession();
        String msg, title;
        if (isSuccess) {
            session.setAttribute("user", name);
            title = "登录成功";
            msg = "管理员" + name + "登录成功！";
            System.out.println("管理员登录成功 - " + name);
        } else {
            title = "登录失败";
            msg = "管理员" + name + "登录失败！";
            System.out.println("管理员登录失败 - " + name);
        }
        session.setAttribute("title", title);
        session.setAttribute("msg", msg);
        resp.sendRedirect("feedback.jsp");
    }
}
