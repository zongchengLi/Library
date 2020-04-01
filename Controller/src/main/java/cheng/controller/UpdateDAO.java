package cheng.controller;

import cheng.database.Book;
import cheng.database.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateDAO extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = (Book) req.getAttribute("book");
        BookDAO bookDAO = new BookDAO();
        boolean isSuccess = bookDAO.updateBookByISBN(book);
        String msg, title;
        if (isSuccess) {
            title = "成功修改信息";
            msg = "成功修改图书信息！";
            System.out.println("成功 - " + book.toString());
        } else {
            title = "修改信息失败";
            msg = "修改图书信息失败！";
            System.out.println("失败 - " + book.toString());
        }
        req.setAttribute("title", title);
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("feedback.jsp").forward(req, resp);
    }
}
