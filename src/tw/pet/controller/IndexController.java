package tw.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {

	@Controller
	public class HomeController {

		@RequestMapping("/")
		public String home() {
			return "index";
		}

	}
}
