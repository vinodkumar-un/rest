
package com.sharekhan.trading.types;

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
 *         &lt;element ref="{http://sharekhan.com/trading/types}personInfo"/>
 *         &lt;element ref="{http://sharekhan.com/trading/types}quoteInfo"/>
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
    "personInfo",
    "quoteInfo"
})
@XmlRootElement(name = "buy")
public class Buy {

    @XmlElement(namespace = "http://sharekhan.com/trading/types", required = true)
    protected PersonInfo personInfo;
    @XmlElement(namespace = "http://sharekhan.com/trading/types", required = true)
    protected QuoteInfo quoteInfo;

    /**
     * Gets the value of the personInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PersonInfo }
     *     
     */
    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    /**
     * Sets the value of the personInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonInfo }
     *     
     */
    public void setPersonInfo(PersonInfo value) {
        this.personInfo = value;
    }

    /**
     * Gets the value of the quoteInfo property.
     * 
     * @return
     *     possible object is
     *     {@link QuoteInfo }
     *     
     */
    public QuoteInfo getQuoteInfo() {
        return quoteInfo;
    }

    /**
     * Sets the value of the quoteInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteInfo }
     *     
     */
    public void setQuoteInfo(QuoteInfo value) {
        this.quoteInfo = value;
    }

}
