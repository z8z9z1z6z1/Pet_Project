package tw.pet.controller.shopping;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SelectOrderByMemberId {
@Autowired
SessionFactory sessionFactory;
public String OrderListByMemberId(Model m) {
//	 MemberBean memberBean= (MemberBean)m.getAttribute("LogionOk");
	 return "";
}
}
