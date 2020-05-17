package tw.pet.controller.shopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import tw.pet.model.shopping.CartBean;
import tw.pet.model.shopping.ProductBean;

@Controller	
public class BuyProductController {
	@Autowired
	SessionFactory  sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public ResponseEntity<ProductBean> addProductToCart(int productId, Model m){
		CartBean cart = (CartBean)m.getAttribute("cart");
		if(cart==null) {
			 cart=new CartBean( );
	            cart.setQuantity(0);
	            cart.setProductCartList(new ArrayList<ProductBean>());
	            
	            m.addAttribute("cart", cart);
		}

		boolean hasProduct=false;
		
		  for (ProductBean productBean : cart.getProductCartList()) {
	            if(productBean.getProductId()==productId){
	                hasProduct=true;
	                productBean.setNum(productBean.getNum()+1);
	                cart.setTotal(cart.getTotal()+product.getPrice());
	                break;
	            }
	        }

		
	}
	
	
}


