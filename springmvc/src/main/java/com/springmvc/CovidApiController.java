package com.springmvc;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.CovidCasesIndia;

@RestController
public class CovidApiController {
	@RequestMapping(value = "/covid", method = RequestMethod.GET)
    public ModelAndView listCovidCases(ModelMap model) {
		RestTemplate restTemplate=new RestTemplate();
		CovidCasesIndia cases=restTemplate.getForObject("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true",
				CovidCasesIndia.class);
		cases.getActiveCases();
		model.put("covid",cases);
		return new ModelAndView("covidReport");
	}
}
