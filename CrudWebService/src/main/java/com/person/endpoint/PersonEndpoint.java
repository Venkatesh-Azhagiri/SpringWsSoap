package com.person.endpoint;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jaxb.person.AddPerson;
import com.jaxb.person.AddPersonResponse;
import com.jaxb.person.DeletePerson;
import com.jaxb.person.DeletePersonResponse;
import com.jaxb.person.ModifyPerson;
import com.jaxb.person.ModifyPersonResponse;
import com.jaxb.person.ViewPerson;
import com.jaxb.person.ViewPersonResponse;
import com.peron.model.Person;

@Endpoint
public class PersonEndpoint {
	private static final String target_name_space = "http://com/crud/person";
	private static final Map<Integer, Person> map = new HashMap<Integer, Person>();
	
	
	@PayloadRoot(localPart="addPerson", namespace=target_name_space)
	public @ResponsePayload AddPersonResponse personAdd(@RequestPayload AddPerson addPersonRequest) throws IllegalAccessException, InvocationTargetException{
		AddPersonResponse personResponse = new AddPersonResponse();
		Person person = new Person();
		BeanUtils.copyProperties(person, addPersonRequest);		
		crudPerson(person, "add");		
		personResponse.setAddPersonResponse("Added");
		return personResponse;		
	}
	
	@PayloadRoot(localPart="viewPerson", namespace=target_name_space)
	public @ResponsePayload ViewPersonResponse personView(@RequestPayload ViewPerson viewPersonRequest) throws IllegalAccessException, InvocationTargetException{
		ViewPersonResponse response  = new ViewPersonResponse();
		System.out.println("View map size "+map.size());
		Person person = new Person();
		BeanUtils.copyProperties(person, viewPersonRequest);		
		Person manipulatedPerson = crudPerson(person, "view");		
		BeanUtils.copyProperties(response, manipulatedPerson);		
		return response;		
	}
	
	@PayloadRoot(localPart="modifyPerson", namespace=target_name_space)
	public @ResponsePayload ModifyPersonResponse modifyPerson(@RequestPayload ModifyPerson modifyPersonRequest) throws IllegalAccessException, InvocationTargetException{
		ModifyPersonResponse response  = new ModifyPersonResponse();
		System.out.println("Modify map size "+map.size());
		Person person = new Person();		
		BeanUtils.copyProperties(person, modifyPersonRequest);
		person = crudPerson(person, "modify");
		response.setModifyPersonResponse("Modified");
		return response;		
	}
	
	@PayloadRoot(localPart="deletePerson", namespace=target_name_space)
	public @ResponsePayload DeletePersonResponse deletePerson(@RequestPayload DeletePerson deletePersonRequest) throws IllegalAccessException, InvocationTargetException{
		DeletePersonResponse response  = new DeletePersonResponse();
		System.out.println("Delete map size "+map.size());
		Person person = new Person();
		BeanUtils.copyProperties(person, deletePersonRequest);
		person = crudPerson(person, "delete");
		response.setDeletePersonResposne("Deleted Successfully");
		return response;		
	}
	private Person crudPerson(Person person, final String operation){
		if(operation.equalsIgnoreCase("add")){
			map.put(person.getPersonId(), person);
		}else if(operation.equalsIgnoreCase("view")){
			if(map.containsKey(person.getPersonId()))
					person  = (Person)map.get(person.getPersonId());
			else
				person= new Person();
		}else if(operation.equalsIgnoreCase("modify")){
			map.put(person.getPersonId(), person);	
		}else if(operation.equalsIgnoreCase("delete")){
			if(map.containsKey(person.getPersonId()))
				map.remove(person.getPersonId());
		}
		return person;
	}
	

}
