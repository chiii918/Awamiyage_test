package websys2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import websys2.bean.Product;


public class ProductDAO {

	/**
	 * 検索条件をもとに検索した商品情報を取得するメソッド
	 * @param keyword
	 * @return
	 */
	public List<Product> search(String category) {

		//検索結果を保持するリストのインスタンスを生成する
		List<Product> list = new ArrayList();

		try {
			//データベース接続インスタンスを取得する
			Connection conn = null;
			conn = DAO.conn;
			if(conn == null) return null;
			System.out.println(conn);

			//変数を宣言し、category名を検索条件としたSELECT文を代入する
			String sql = "SELECT * FROM product WHERE category = '" + category + "';";

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println(pStmt);

			//SELECTを実行し、結果を取得してResultSetのインスタンスに代入
			ResultSet rs = pStmt.executeQuery();

			System.out.println(rs);

			//rs結果表に格納されたレコードを行ごとに取得して出力する
			while (rs.next()) {

				//Product Beanのインスタンスを生成する
				Product p = new Product();

				//productのデータを取得
				p.setId(rs.getInt("id"));			//Id
				p.setName(rs.getString("name"));	//name
				p.setPrice(rs.getInt("price"));		//price
				p.setCategory(rs.getString("category"));		//category

				//セッティング済のBeanをリストに追加する
				list.add(p);
			}

			pStmt.close();
			rs.close();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//検索結果を集めているlistを呼び出す先に返す
		return list;

	}


}
