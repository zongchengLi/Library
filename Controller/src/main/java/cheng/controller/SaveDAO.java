package cheng.controller;

import cheng.database.Book;
import cheng.database.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Li Zongcheng
 * @create 2020-03-26 16:10
 */

@WebServlet("/save")
public class SaveDAO extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Book book = (Book) req.getAttribute("book");
        System.out.println(book.toString());
        BookDAO bookDAO = new BookDAO();
        boolean isSuccess = bookDAO.save(book);
        String msg;
        if (isSuccess) {
            msg = "成功提交图书信息！";
            System.out.println("成功 - " + book.toString());
        } else {
            msg = "提交图书信息失败！";
            System.out.println("失败 - " + book.toString());
        }
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("admin/save.jsp").forward(req, resp);
    }

}
