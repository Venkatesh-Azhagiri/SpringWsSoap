//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.04 at 08:09:24 PM IST 
//


package com.crud.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="personName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="personDesignation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personId",
    "personName",
    "personAge",
    "personDesignation"
})
@XmlRootElement(name = "viewPersonResponse")
public class ViewPersonResponse {

    protected int personId;
    @XmlElement(required = true)
    protected String personName;
    protected int personAge;
    @XmlElement(required = true)
    protected String personDesignation;

    /**
     * Gets the value of the personId property.
     * 
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     */
    public void setPersonId(int value) {
        this.personId = value;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonName(String value) {
        this.personName = value;
    }

    /**
     * Gets the value of the personAge property.
     * 
     */
    public int getPersonAge() {
        return personAge;
    }

    /**
     * Sets the value of the personAge property.
     * 
     */
    public void setPersonAge(int value) {
        this.personAge = value;
    }

    /**
     * Gets the value of the personDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonDesignation() {
        return personDesignation;
    }

    /**
     * Sets the value of the personDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonDesignation(String value) {
        this.personDesignation = value;
    }

}
