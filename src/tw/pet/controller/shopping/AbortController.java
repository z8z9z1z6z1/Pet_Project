package tw.pet.controller.shopping;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.pet.model.shopping.CartBean;
//放棄購買
@Controller
public class AbortController {
	@Autowired
	SessionFactory	 sessionFactory;
	
	@GetMapping("/abortBuy")
	public String abortBuy(Model m,HttpServletRequest request) {
		CartBean cart = (CartBean) request.getAttribute("cart");
		if(cart==null) {
			System.out.println("無購物車商品");
			return "showProduct";
		}
		request.removeAttribute("cart");
		return "showProduct";
	}
	
}
