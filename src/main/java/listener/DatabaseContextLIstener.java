package listener;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseContextLIstener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        MysqlDataSource ds = new MysqlDataSource();
        ds.setDatabaseName("dv");
        ds.setUser("root");
        ds.setPassword("root");
        context.setAttribute("DBDataSource", ds);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
