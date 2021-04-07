package com.springmvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("/hello")  
    public String display(HttpServletRequest req,Model m)  
    {  
        //read the provided form data  
        String name=req.getParameter("name");  
        String pass=req.getParameter("pass");  
        if(pass.equals("admin"))  
        {  
            String msg="Hello "+ name;  
            //add a message to the model  
            m.addAttribute("message", msg);  
            return "view";  
        }  
        else  
        {  
            String msg="Sorry "+ name+". You entered an incorrect password";  
            m.addAttribute("message", msg);  
            return "errorpage";  
        }     
    }
	@RequestMapping("/count")
	public String countLetter(@RequestParam("sentence")String sentence,Model m) {
		int totalLength=0,letterCount=0,spaceCount=0,specialCount=0,numCount=0;
		totalLength=sentence.length();
		for(int i=0;i<totalLength;i++) {
			char ch=sentence.charAt(i);
			if(ch>='a'&& ch<='z'||ch>='A'&&ch<='Z') {
				letterCount++;
			}
			else if(ch==' ') {
				spaceCount++;
			}
			else if(ch>='0' && ch<='9') {
				numCount++;
			}
			else {
				specialCount++;
			}
		}
		m.addAttribute("totalLength", totalLength);
		m.addAttribute("letterCount", letterCount);
		m.addAttribute("spaceCount", spaceCount);
		m.addAttribute("numCount", numCount);
		m.addAttribute("specialCount", specialCount);
		return "welcome";
	}
}
