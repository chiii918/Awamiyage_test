package websys2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import websys2.dao.DAO;


@WebListener
public class Weblistener implements ServletContextListener {

	public Weblistener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 * DB接続を切断する
	 */
	public void contextDestroyed(ServletContextEvent sce)  {
		DAO.dbDisconnection();
		System.out.println("products: DB connection is close.");
		ServletContext sc = sce.getServletContext();
		sc.log(sc.getServletContextName() + "END!!");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 * Web.xmlからcontextを取得し、DBに接続
	 */
	public void contextInitialized(ServletContextEvent sce)  {
		// Web.xmlからcontextを取得
		ServletContext srvc = sce.getServletContext();

		DAO.jdbcDriver = srvc.getInitParameter("jdbcDriver");
		DAO.jdbcUri = srvc.getInitParameter("jdbcUri");
		DAO.dbUser = srvc.getInitParameter("dbUser");
		DAO.dbPassword = srvc.getInitParameter("dbPassword");

		//DBに接続
		boolean dbc = DAO.dbConnection();

		System.out.println("products: DB connection is done." + dbc);
		ServletContext sc = sce.getServletContext();
		sc.log(sc.getServletContextName() + "START!!");

	}
}
