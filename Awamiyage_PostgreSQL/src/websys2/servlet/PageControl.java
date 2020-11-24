package websys2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageControl
 */
@WebServlet("/PageControl")
public class PageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		//ページ番号
		String para1 = request.getParameter("pg_id");

		String forward = "";
		int pg_id = 0;

		//入力値チェック
		if (para1 != null && para1.length() != 0) {
			pg_id = Integer.parseInt(para1);
		}

		// リクエストスコープに保存
		request.setAttribute("pg_id", pg_id);

		//リクエストスコープに各ページ用情報保存、フォワード先を設定
		if (pg_id==1) {
			//トップページ
			forward = movetoTop(request);
		} else if (pg_id==2) {
			//コンセプトページ
			//forward = movetoConcept(request);
		} else if (pg_id==3) {
			//メニューページ
			//forward = movetoMenu(request);
		} else if (pg_id==4) {
			//CMS用ログインページ
			//forward = movetoLogin();
		} else {
			//トップページ
			forward = movetoTop(request);
		}

		//メイン画面にフォーワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);


	}

	private String movetoMenu(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoConcept(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoLogin() {
		// フォーワード先 "
		String forward = "WEB-INF/jsp/top.jsp";
		return forward;
	}


	/**
	 * トップページフォワード前処理
	 *
	 * @return フォワード用パス
	 */
	private String movetoTop(HttpServletRequest request) {
		// フォーワード先 "
		String forward = "WEB-INF/jsp/login_in.jsp";
		return forward;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
