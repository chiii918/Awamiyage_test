package websys2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	//データベースに接続する情報
	public static String jdbcDriver;	//ドライバー名
	public static String jdbcUri;		//Uri
	public static String dbUser;		//DBのログインユーザーID
	public static String dbPassword;	//DBのログインパスワード

	public static Connection conn;		//Connection

	/**
	 * データベースに接続
	 * @return
	 */
	public static boolean dbConnection() {
		conn = null;
		try {

			Class.forName(jdbcDriver);
			//conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			conn = DriverManager.getConnection(jdbcUri,dbUser,dbPassword);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;

	}

	/**
	 * データベースを切断する
	 * @param conn
	 * @return
	 */
	public static boolean dbDisconnection() {

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * データベースに接続するインスタンスを取得する
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;		//ConnectionJDBC_URL

		try {
			Class.forName(jdbcDriver);

			conn = DriverManager.getConnection(jdbcUri,dbUser,dbPassword);

			System.out.println("getConnection: 成功");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

			System.out.println("getConnection: 失敗" + e.getMessage());

		}

		//DB接続のインスタンスを返す
		return conn;
	}

	/**
	 * データベースに接続するインスタンスを切断する
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {

		try {
			conn.close();

			System.out.println("closeConnection: 成功" );
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
			System.out.println("closeConnection: 失敗" + e.getMessage());
		}
	}
}
