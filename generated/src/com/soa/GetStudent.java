
package com.soa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getStudent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudent", propOrder = {
    "getStudent"
})
public class GetStudent {

    protected String getStudent;

    /**
     * Gets the value of the getStudent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetStudent() {
        return getStudent;
    }

    /**
     * Sets the value of the getStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetStudent(String value) {
        this.getStudent = value;
    }

}
