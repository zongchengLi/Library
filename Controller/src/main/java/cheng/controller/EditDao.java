package cheng.controller;

import cheng.database.Book;
import cheng.database.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditDao extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String in_ISBN = req.getParameter("ISBN");
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.selectBookByISBN(in_ISBN);
        req.setAttribute("book", book);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
