/**
 * TravelInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.co.irct.types;

public class TravelInfo  implements java.io.Serializable {
    private java.lang.String src;

    private java.lang.String dest;

    private java.util.Date doj;

    public TravelInfo() {
    }

    public TravelInfo(
           java.lang.String src,
           java.lang.String dest,
           java.util.Date doj) {
           this.src = src;
           this.dest = dest;
           this.doj = doj;
    }


    /**
     * Gets the src value for this TravelInfo.
     * 
     * @return src
     */
    public java.lang.String getSrc() {
        return src;
    }


    /**
     * Sets the src value for this TravelInfo.
     * 
     * @param src
     */
    public void setSrc(java.lang.String src) {
        this.src = src;
    }


    /**
     * Gets the dest value for this TravelInfo.
     * 
     * @return dest
     */
    public java.lang.String getDest() {
        return dest;
    }


    /**
     * Sets the dest value for this TravelInfo.
     * 
     * @param dest
     */
    public void setDest(java.lang.String dest) {
        this.dest = dest;
    }


    /**
     * Gets the doj value for this TravelInfo.
     * 
     * @return doj
     */
    public java.util.Date getDoj() {
        return doj;
    }


    /**
     * Sets the doj value for this TravelInfo.
     * 
     * @param doj
     */
    public void setDoj(java.util.Date doj) {
        this.doj = doj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TravelInfo)) return false;
        TravelInfo other = (TravelInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.src==null && other.getSrc()==null) || 
             (this.src!=null &&
              this.src.equals(other.getSrc()))) &&
            ((this.dest==null && other.getDest()==null) || 
             (this.dest!=null &&
              this.dest.equals(other.getDest()))) &&
            ((this.doj==null && other.getDoj()==null) || 
             (this.doj!=null &&
              this.doj.equals(other.getDoj())));
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
        if (getSrc() != null) {
            _hashCode += getSrc().hashCode();
        }
        if (getDest() != null) {
            _hashCode += getDest().hashCode();
        }
        if (getDoj() != null) {
            _hashCode += getDoj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TravelInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://irct.co.in/types", "TravelInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("src");
        elemField.setXmlName(new javax.xml.namespace.QName("", "src"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
