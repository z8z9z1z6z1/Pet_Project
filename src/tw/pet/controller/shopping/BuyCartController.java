package tw.pet.controller.shopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public void addProductToCart(Model m,HttpServletRequest request){
		// 取出存放在session物件內的ShoppingCart物件
		HttpSession session = request.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		if(cart==null) {
			 cart=new CartBean( );      
			 session.setAttribute("cart", cart);
		}
		Integer  productId =(Integer) request.getAttribute("productId");
		String name=(String)request.getAttribute("name");
//		String quantityStr=(String)m.getAttribute("quantity");
		Integer quantity=(Integer)request.getAttribute("quantity");
		Double unitPrice=(Double)request.getAttribute("unitPrice");
		Double discount=(Double)request.getAttribute("discount");
		//新增一筆訂單明細
		//每一個訂單有複數個訂單明細
		OrderItemBean oItemBean =
				new OrderItemBean(productId, name, quantity, unitPrice, discount);
		cart.addToCart(productId, oItemBean);
	}
	
	
	
}


