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
import java.util.ArrayList;
import java.util.List;


public class GetUserController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlDataSource ds = (MysqlDataSource) req.getServletContext().getAttribute("DBDataSource");

        try (Connection con = ds.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select name, surname, amount\n" +
                     "from users\n" +
                     "left join accounts\n" +
                     "on users.user_id = accounts.user_id\n" +
                     "where  amount = (select max(amount) from accounts)\n" +
                     "order by accounts.user_id;")) {

            List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setSurName(rs.getString("surName"));
                user.setAmount(rs.getInt("amount"));
                userList.add(user);
            }
            req.setAttribute("getUser", userList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showRichestUser.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}