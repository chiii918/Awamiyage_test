package websys2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import websys2.bean.Product;
import websys2.dao.ProductDAO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		//データベースに接続、読み込み
		ProductDAO dao = new ProductDAO();

		//検索結果を保持するリストのインスタンスを生成する
		List<Product> product_list = new ArrayList<Product>();

		// nameがcategoryのvalueを取得
		String category = request.getParameter("category");

		// ProductDAOのsearchメソッドに引数としてcategoryを渡した検索結果を取得する
		product_list = dao.search(category);

		// リクエストをsearch.jspに渡す
		request.setAttribute("product_list", product_list);
		request.setAttribute("title", category);
		//フォワード
		request.getRequestDispatcher("/jsp/search.jsp").forward(request, response);


	}

}
