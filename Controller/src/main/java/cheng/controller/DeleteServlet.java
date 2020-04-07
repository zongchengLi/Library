package cheng.controller;

import cheng.database.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        BookDAO bookDAO = new BookDAO();
        String ISBN = req.getParameter("ISBN");
        boolean isSuccess = bookDAO.deleteBookByISBN(ISBN);
        String title, msg;
        if (isSuccess) {
            title = "成功删除信息";
            msg = "成功删除图书信息！";
            System.out.println(ISBN + " - " + msg);
        } else {
            title = "删除信息失败";
            msg = "删除图书信息失败！";
            System.out.println(ISBN + " - " + msg);
        }
        session.setAttribute("title", title);
        session.setAttribute("msg", msg);
        resp.sendRedirect("../feedback.jsp");
    }
}
