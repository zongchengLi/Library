package cheng.controller;

import cheng.database.Book;
import cheng.database.BookDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Li Zongcheng
 * @create 2020-03-27 16:21
 */

@WebServlet("/query")
public class QueryDAO extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
        List<Book> L = bookDAO.query();
        req.setAttribute("books", L);
        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }

}
