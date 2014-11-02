package com.dynamic.wsdl.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class SquareServiceImpl implements SquareService {
 
    public BigInteger square(BigInteger bigInteger) {
        return (bigInteger.multiply(bigInteger));
    }
 
}