
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
 *         &lt;element name="order_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stock_nm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    "orderId",
    "stockNm",
    "price",
    "quantity",
    "totalAmount"
})
@XmlRootElement(name = "stockInfo")
public class StockInfo {

    @XmlElement(name = "order_id")
    protected int orderId;
    @XmlElement(name = "stock_nm", required = true)
    protected String stockNm;
    protected float price;
    protected int quantity;
    protected float totalAmount;

    /**
     * Gets the value of the orderId property.
     * 
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     */
    public void setOrderId(int value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the stockNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockNm() {
        return stockNm;
    }

    /**
     * Sets the value of the stockNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockNm(String value) {
        this.stockNm = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     */
    public void setTotalAmount(float value) {
        this.totalAmount = value;
    }

}
