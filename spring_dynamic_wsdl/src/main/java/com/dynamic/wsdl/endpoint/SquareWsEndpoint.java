package com.dynamic.wsdl.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dynamic.wsdl.jaxb.generated.ObjectFactory;
import com.dynamic.wsdl.jaxb.generated.SquareServiceRequest;
import com.dynamic.wsdl.jaxb.generated.SquareServiceResponse;
import com.dynamic.wsdl.service.SquareService;

 


@Endpoint
public class SquareWsEndpoint {
    //To calculate square of the input.
    @Autowired
    private SquareService squareService;
    //This is like @RequestMapping of Spring MVC
    //http://ankeetmaini.wordpress.com/spring-ws2-square
    //http://com/blog/samples/webservices/accountservice
    @PayloadRoot(localPart="SquareServiceRequest", namespace="com/dynamic/wsdl/jaxb/generated")
    //@ResponsePayload
    public @ResponsePayload SquareServiceResponse getSquare(@RequestPayload SquareServiceRequest request) {
    	System.out.println("Endpoint test1*****");
    	//SquareServiceResponse response = new SquareServiceResponse();
    	SquareServiceResponse response = new ObjectFactory().createSquareServiceResponse();    	
        response.setOutput(squareService.square(request.getInput()));
    	return response;
    }
}