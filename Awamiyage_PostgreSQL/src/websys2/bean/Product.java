package websys2.bean;

import java.io.Serializable;

public class Product implements Serializable{

	private int id;
	private String name;
	private int price;
	private String category;

	/**
	 * コンストラクタ
	 */
	public Product() {

	}

	public void setId(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int price) {
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
