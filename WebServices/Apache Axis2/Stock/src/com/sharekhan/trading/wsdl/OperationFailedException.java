
/**
 * OperationFailedException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

package com.sharekhan.trading.wsdl;

public class OperationFailedException extends java.lang.Exception{

    private static final long serialVersionUID = 1405835487298L;
    
    private com.sharekhan.trading.types.Reason faultMessage;

    
        public OperationFailedException() {
            super("OperationFailedException");
        }

        public OperationFailedException(java.lang.String s) {
           super(s);
        }

        public OperationFailedException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public OperationFailedException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.sharekhan.trading.types.Reason msg){
       faultMessage = msg;
    }
    
    public com.sharekhan.trading.types.Reason getFaultMessage(){
       return faultMessage;
    }
}
    