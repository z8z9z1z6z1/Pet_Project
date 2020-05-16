package tw.pet.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.pet.model.PetMembers;
import tw.pet.service.MemberService;

@Controller
@SessionAttributes(value={"petMembers"})
public class MemberController {

	@Autowired
	private MemberService ms;

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public String processRregister() {
			return "Member/memberRegister";
//			return "Member/register";
		}

		@RequestMapping(value = "/registerInsert", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
		public String saveMembers(@ModelAttribute("member") PetMembers member, BindingResult bindingResult) {
			PetMembers n = ms.saveMember(member);
			if (n != null) {
				return "../../index";
			} else {
				return "Member/memberRegister";
//				return "Member/register";

			}
		}
		
		@RequestMapping(path = "/login", method = RequestMethod.GET)
		public String processLogin() {
			return "Member/memberLogin";
//			return "Member/login";
		}
		
		@RequestMapping(path = "/loginCheck", method = RequestMethod.POST)
		public String loginCheck(@RequestParam("email") String email, @RequestParam("password") String password, Model m,  HttpServletRequest req) {

			Map<String, String> errors = new HashMap<String, String>();	

			if(email==null || email.length()==0) {
				errors.put("email", "email is required");
			}
			
			if(password==null || password.length()==0) {
				errors.put("password", "password is required");
			}
			
			m.addAttribute("errors", errors);
			
			if(errors!=null && !errors.isEmpty()) {
				return "Member/memberLogin";
//				return "Member/login";
			}
			
			PetMembers result = ms.checkIDPassword(email, password);
			
			m.addAttribute("email", email);
			m.addAttribute("password", password);
			
//			HttpSession rsession = req.getSession();
//			rsession.setAttribute("petMembers", result);
			
			if(result != null) {
				m.addAttribute("petMembers", result);
				return "../../index";
			}
			
			errors.put("msg", "Please Input Correct username or password");
			return "Member/memberLogin";
//			return "Member/login";

		}
		
		@RequestMapping(path = "/logout", method = RequestMethod.GET)
		public String processLogout() {
			return "Member/logout";
		}
		
	}
