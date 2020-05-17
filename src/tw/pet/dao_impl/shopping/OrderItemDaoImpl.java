package tw.pet.dao_impl.shopping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.pet.model.shopping.OrderDetailBean;
@Repository
public class OrderItemDaoImpl {
	SessionFactory sessionFactory;
	
	public OrderItemDaoImpl() {
	}
	
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	/*
	 * 計算客戶欲購買之某項商品(以OrderItemBean物件oib來表示)的小計金額(subtotal)， 
	 * 計算公式為: 商品的數量 * 商品的單價  * 商品的折扣
	 */
	public double findItemAmount(OrderDetailBean oib) {
		double subtotal = oib.getQuantity() * oib.getUnitPrice() * oib.getDiscount();
		return subtotal;
	}
	
	
}
