package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetSumController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlDataSource ds = (MysqlDataSource) req.getServletContext().getAttribute("DBDataSource");

        try (Connection con = ds.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT SUM(amount) AS OrderTotal FROM accounts")) {
            User user = new User();
            while (rs.next()) {

                user.setAmount(rs.getInt("OrderTotal"));
            }


            req.setAttribute("getSum", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showSum.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}