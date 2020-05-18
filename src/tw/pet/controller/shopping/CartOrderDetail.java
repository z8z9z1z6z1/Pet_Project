package tw.pet.controller.shopping;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import tw.pet.dao_impl.shopping.OrderDao;
import tw.pet.model.shopping.OrderBean;
//依照會員編號與訂單編號來讀取某筆訂單的所有資料，這些資料將封裝為一個OrderBean物件
@Controller
public class CartOrderDetail {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	OrderDao orderDao;
	
	@PostMapping(value = "addOrderBean")
	public  String addOrderBean(Model m) {
		Integer orderId = (Integer)m.getAttribute("orderId");
		OrderBean ob = orderDao.selectOrder(orderId);
		m.addAttribute("OrderBean", ob);// 將OrderBean物件暫存到請求物件內
		System.out.println("測試  查看訂單="+ob);
		return "showOrderDetail";
	}
}
