package mavendemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String display(@RequestParam("name")String name,@RequestParam("pass")String pass, Model m) {
		if(pass.equals("admin")) {
			String message="Hello "+name;
			m.addAttribute("message",message);
			return "viewpage";
		}
		else {
			String message="Sorry "+name+" you entered a wrong password";
			m.addAttribute("message",message);
			return "errorpage";
		}
	}
}