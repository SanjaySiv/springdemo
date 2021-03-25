package mavendemo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String display(HttpServletRequest req, Model m) {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
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