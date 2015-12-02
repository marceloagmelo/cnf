/**
 * RetornoParcelas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class RetornoParcelas  implements java.io.Serializable {
    private java.lang.String parcela;

    private java.lang.String valorTotal;

    private java.lang.String valorParcela;

    private java.lang.String obs;

    private java.lang.String mensagem;

    public RetornoParcelas() {
    }

    public RetornoParcelas(
           java.lang.String parcela,
           java.lang.String valorTotal,
           java.lang.String valorParcela,
           java.lang.String obs,
           java.lang.String mensagem) {
           this.parcela = parcela;
           this.valorTotal = valorTotal;
           this.valorParcela = valorParcela;
           this.obs = obs;
           this.mensagem = mensagem;
    }


    /**
     * Gets the parcela value for this RetornoParcelas.
     * 
     * @return parcela
     */
    public java.lang.String getParcela() {
        return parcela;
    }


    /**
     * Sets the parcela value for this RetornoParcelas.
     * 
     * @param parcela
     */
    public void setParcela(java.lang.String parcela) {
        this.parcela = parcela;
    }


    /**
     * Gets the valorTotal value for this RetornoParcelas.
     * 
     * @return valorTotal
     */
    public java.lang.String getValorTotal() {
        return valorTotal;
    }


    /**
     * Sets the valorTotal value for this RetornoParcelas.
     * 
     * @param valorTotal
     */
    public void setValorTotal(java.lang.String valorTotal) {
        this.valorTotal = valorTotal;
    }


    /**
     * Gets the valorParcela value for this RetornoParcelas.
     * 
     * @return valorParcela
     */
    public java.lang.String getValorParcela() {
        return valorParcela;
    }


    /**
     * Sets the valorParcela value for this RetornoParcelas.
     * 
     * @param valorParcela
     */
    public void setValorParcela(java.lang.String valorParcela) {
        this.valorParcela = valorParcela;
    }


    /**
     * Gets the obs value for this RetornoParcelas.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this RetornoParcelas.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the mensagem value for this RetornoParcelas.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this RetornoParcelas.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetornoParcelas)) return false;
        RetornoParcelas other = (RetornoParcelas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parcela==null && other.getParcela()==null) || 
             (this.parcela!=null &&
              this.parcela.equals(other.getParcela()))) &&
            ((this.valorTotal==null && other.getValorTotal()==null) || 
             (this.valorTotal!=null &&
              this.valorTotal.equals(other.getValorTotal()))) &&
            ((this.valorParcela==null && other.getValorParcela()==null) || 
             (this.valorParcela!=null &&
              this.valorParcela.equals(other.getValorParcela()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem())));
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
        if (getParcela() != null) {
            _hashCode += getParcela().hashCode();
        }
        if (getValorTotal() != null) {
            _hashCode += getValorTotal().hashCode();
        }
        if (getValorParcela() != null) {
            _hashCode += getValorParcela().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetornoParcelas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "RetornoParcelas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parcela");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Parcela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ValorTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorParcela");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ValorParcela"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
