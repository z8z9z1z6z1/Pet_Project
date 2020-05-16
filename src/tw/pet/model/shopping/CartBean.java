package tw.pet.model.shopping;

import org.springframework.stereotype.Component;


public class CartBean {
	private int quantity; // 數量
	private Double price;// 總價格
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public CartBean(int quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	
}
