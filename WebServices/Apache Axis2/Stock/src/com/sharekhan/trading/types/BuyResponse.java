
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
 *         &lt;element ref="{http://sharekhan.com/trading/types}stockInfo"/>
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
    "stockInfo"
})
@XmlRootElement(name = "buyResponse")
public class BuyResponse {

    @XmlElement(namespace = "http://sharekhan.com/trading/types", required = true)
    protected StockInfo stockInfo;

    /**
     * Gets the value of the stockInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StockInfo }
     *     
     */
    public StockInfo getStockInfo() {
        return stockInfo;
    }

    /**
     * Sets the value of the stockInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockInfo }
     *     
     */
    public void setStockInfo(StockInfo value) {
        this.stockInfo = value;
    }

}
