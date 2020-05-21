package tw.pet.controller.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.pet.dao_impl.shopping.OrderDao;
import tw.pet.model.PetMembers;
import tw.pet.model.shopping.OrderBean;

@Controller
public class SelectOrderByMemberId {
@Autowired
SessionFactory sessionFactory;
@Autowired
OrderDao orderDao;


//ajax方法
@GetMapping(value = "/利用ID查循", produces= {"application/json"} )
public ResponseEntity<List<OrderBean>> OrderListByMemberIdAjax(Model m,HttpServletRequest request) {
//	 MemberBean memberBean= (MemberBean)m.getAttribute("LogionOk");
	HttpSession session = request.getSession();
	Object LoginOk = session.getAttribute("LoginOk");
	if(LoginOk==null) {
		System.out.println("沒有訂單紀錄");
		return null;
	}
	PetMembers member =  (PetMembers) session.getAttribute("member");
	List<OrderBean> memberOrders =orderDao.selectOrderByMemberId(member.getMemberId());
	ResponseEntity<List<OrderBean>> re = new ResponseEntity<List<OrderBean>>(memberOrders, HttpStatus.OK);
	 return re;
}

@GetMapping(value = "/點籍網頁")
	public String  OrderListByMemberId(Model m,HttpServletRequest request){
		HttpSession session = request.getSession();
		Object LoginOk = session.getAttribute("LoginOk");
		if(LoginOk==null) {
			System.out.println("沒有訂單紀錄");
			return "請登入";
	}
		PetMembers member =  (PetMembers) session.getAttribute("member");
		List<OrderBean> memberOrders =orderDao.selectOrderByMemberId(member.getMemberId());
		session.setAttribute("orderList", memberOrders);
		return "showOrderList";
}
	
}	
