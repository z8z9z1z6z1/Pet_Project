package tw.pet.controller.shopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tw.pet.model.shopping.CartBean;
import tw.pet.model.shopping.OrderDetailBean;
import tw.pet.model.shopping.OrderItemBean;
import tw.pet.model.shopping.ProductBean;

@Controller	
public class BuyCartController {
	@Autowired
	SessionFactory  sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@PostMapping(value = "/addProductToCart")
	public void addProductToCart(Model m){
		// 取出存放在session物件內的ShoppingCart物件
		CartBean cart = (CartBean)m.getAttribute("cart");
		if(cart==null) {
			 cart=new CartBean( );      
	            m.addAttribute("cart", cart);
		}
		Integer  productId =(Integer) m.getAttribute("productId");
		String name=(String)m.getAttribute("name");
//		String quantityStr=(String)m.getAttribute("quantity");
		Integer quantity=(Integer)m.getAttribute("quantity");
		Double unitPrice=(Double)m.getAttribute("unitPrice");
		Double discount=(Double)m.getAttribute("discount");
		//新增一筆訂單明細
		//每一個訂單有複數個訂單明細
		OrderItemBean oItemBean =
				new OrderItemBean(productId, name, quantity, unitPrice, discount);
		cart.addToCart(productId, oItemBean);
	}
	
	
	
}


