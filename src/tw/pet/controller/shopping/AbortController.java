package tw.pet.controller.shopping;

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
	public String abortBuy(Model m) {
		CartBean cart = (CartBean) m.getAttribute("cart");
		if(cart==null) {
			return "showProduct";
		}
		cart=null;
		m.addAttribute("cart",cart);
		return "showProduct";
	}
	
}
