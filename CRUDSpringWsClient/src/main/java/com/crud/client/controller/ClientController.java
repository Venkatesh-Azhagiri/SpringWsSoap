package com.crud.client.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.crud.jaxb.AddPerson;
import com.crud.jaxb.AddPersonResponse;
import com.person.model.Person;

@Controller
public class ClientController {
	@Resource
	private WebServiceTemplate webserviceTemplate;
	
	@RequestMapping(value = "/addPerson", method =RequestMethod.POST)
	public String addPersonResponse(@ModelAttribute("person") Person person){
		
		return "add";
		
	}
	
	@RequestMapping(value = "/add", method =RequestMethod.GET)
	public String addPerson(@ModelAttribute("person") Person person){
		AddPerson addPerson  = new AddPerson();
		addPerson.setPersonId(1);
		addPerson.setPersonName("Test");
		addPerson.setPersonAge(28);
		addPerson.setPersonDesignation("Software Engineer");
		AddPersonResponse response = (AddPersonResponse)webserviceTemplate.marshalSendAndReceive(addPerson);
		System.out.println("Get Method"+response.getAddPersonResponse());
		return "add";
		
	}

}
