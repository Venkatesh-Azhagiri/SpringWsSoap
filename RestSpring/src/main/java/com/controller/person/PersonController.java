package com.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.person.Person;

@Controller	
public class PersonController {
	
	@RequestMapping(value="persons/{id}", method=RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int id){
		System.out.println("Person Id "+id);
		Person p = new Person();
		p.setPersonName("Venkatesh");
		return p;
		
	}

}
