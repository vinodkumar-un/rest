/**
 * TicketInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.co.irct.types;

public class TicketInfo  implements java.io.Serializable {
    private java.lang.String pnr;

    private java.lang.String coach;

    private java.lang.Integer berth;

    private java.lang.String status;

    public TicketInfo() {
    }

    public TicketInfo(
           java.lang.String pnr,
           java.lang.String coach,
           java.lang.Integer berth,
           java.lang.String status) {
           this.pnr = pnr;
           this.coach = coach;
           this.berth = berth;
           this.status = status;
    }


    /**
     * Gets the pnr value for this TicketInfo.
     * 
     * @return pnr
     */
    public java.lang.String getPnr() {
        return pnr;
    }


    /**
     * Sets the pnr value for this TicketInfo.
     * 
     * @param pnr
     */
    public void setPnr(java.lang.String pnr) {
        this.pnr = pnr;
    }


    /**
     * Gets the coach value for this TicketInfo.
     * 
     * @return coach
     */
    public java.lang.String getCoach() {
        return coach;
    }


    /**
     * Sets the coach value for this TicketInfo.
     * 
     * @param coach
     */
    public void setCoach(java.lang.String coach) {
        this.coach = coach;
    }


    /**
     * Gets the berth value for this TicketInfo.
     * 
     * @return berth
     */
    public java.lang.Integer getBerth() {
        return berth;
    }


    /**
     * Sets the berth value for this TicketInfo.
     * 
     * @param berth
     */
    public void setBerth(java.lang.Integer berth) {
        this.berth = berth;
    }


    /**
     * Gets the status value for this TicketInfo.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this TicketInfo.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TicketInfo)) return false;
        TicketInfo other = (TicketInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pnr==null && other.getPnr()==null) || 
             (this.pnr!=null &&
              this.pnr.equals(other.getPnr()))) &&
            ((this.coach==null && other.getCoach()==null) || 
             (this.coach!=null &&
              this.coach.equals(other.getCoach()))) &&
            ((this.berth==null && other.getBerth()==null) || 
             (this.berth!=null &&
              this.berth.equals(other.getBerth()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPnr() != null) {
            _hashCode += getPnr().hashCode();
        }
        if (getCoach() != null) {
            _hashCode += getCoach().hashCode();
        }
        if (getBerth() != null) {
            _hashCode += getBerth().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TicketInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://irct.co.in/types", "TicketInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pnr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coach");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coach"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("berth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "berth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
