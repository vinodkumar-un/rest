
package com.sharekhan.trading.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sharekhan.trading.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sharekhan.trading.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StockInfo }
     * 
     */
    public StockInfo createStockInfo() {
        return new StockInfo();
    }

    /**
     * Create an instance of {@link Reason }
     * 
     */
    public Reason createReason() {
        return new Reason();
    }

    /**
     * Create an instance of {@link PersonInfo }
     * 
     */
    public PersonInfo createPersonInfo() {
        return new PersonInfo();
    }

    /**
     * Create an instance of {@link Buy }
     * 
     */
    public Buy createBuy() {
        return new Buy();
    }

    /**
     * Create an instance of {@link BuyResponse }
     * 
     */
    public BuyResponse createBuyResponse() {
        return new BuyResponse();
    }

    /**
     * Create an instance of {@link QuoteInfo }
     * 
     */
    public QuoteInfo createQuoteInfo() {
        return new QuoteInfo();
    }

}
