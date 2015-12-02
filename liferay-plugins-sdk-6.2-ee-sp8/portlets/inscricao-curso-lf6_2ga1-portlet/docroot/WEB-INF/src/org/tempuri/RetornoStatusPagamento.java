/**
 * RetornoStatusPagamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class RetornoStatusPagamento  implements java.io.Serializable {
    private java.lang.String pedidoNumeroLoja;

    private java.lang.String status;

    private java.lang.String modulo;

    private java.lang.String meioPagamento;

    private java.lang.String dataPagamento;

    private java.lang.String valorPago;

    private java.lang.String nivelRisco;

    private java.lang.String mensagem;

    public RetornoStatusPagamento() {
    }

    public RetornoStatusPagamento(
           java.lang.String pedidoNumeroLoja,
           java.lang.String status,
           java.lang.String modulo,
           java.lang.String meioPagamento,
           java.lang.String dataPagamento,
           java.lang.String valorPago,
           java.lang.String nivelRisco,
           java.lang.String mensagem) {
           this.pedidoNumeroLoja = pedidoNumeroLoja;
           this.status = status;
           this.modulo = modulo;
           this.meioPagamento = meioPagamento;
           this.dataPagamento = dataPagamento;
           this.valorPago = valorPago;
           this.nivelRisco = nivelRisco;
           this.mensagem = mensagem;
    }


    /**
     * Gets the pedidoNumeroLoja value for this RetornoStatusPagamento.
     * 
     * @return pedidoNumeroLoja
     */
    public java.lang.String getPedidoNumeroLoja() {
        return pedidoNumeroLoja;
    }


    /**
     * Sets the pedidoNumeroLoja value for this RetornoStatusPagamento.
     * 
     * @param pedidoNumeroLoja
     */
    public void setPedidoNumeroLoja(java.lang.String pedidoNumeroLoja) {
        this.pedidoNumeroLoja = pedidoNumeroLoja;
    }


    /**
     * Gets the status value for this RetornoStatusPagamento.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this RetornoStatusPagamento.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the modulo value for this RetornoStatusPagamento.
     * 
     * @return modulo
     */
    public java.lang.String getModulo() {
        return modulo;
    }


    /**
     * Sets the modulo value for this RetornoStatusPagamento.
     * 
     * @param modulo
     */
    public void setModulo(java.lang.String modulo) {
        this.modulo = modulo;
    }


    /**
     * Gets the meioPagamento value for this RetornoStatusPagamento.
     * 
     * @return meioPagamento
     */
    public java.lang.String getMeioPagamento() {
        return meioPagamento;
    }


    /**
     * Sets the meioPagamento value for this RetornoStatusPagamento.
     * 
     * @param meioPagamento
     */
    public void setMeioPagamento(java.lang.String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }


    /**
     * Gets the dataPagamento value for this RetornoStatusPagamento.
     * 
     * @return dataPagamento
     */
    public java.lang.String getDataPagamento() {
        return dataPagamento;
    }


    /**
     * Sets the dataPagamento value for this RetornoStatusPagamento.
     * 
     * @param dataPagamento
     */
    public void setDataPagamento(java.lang.String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    /**
     * Gets the valorPago value for this RetornoStatusPagamento.
     * 
     * @return valorPago
     */
    public java.lang.String getValorPago() {
        return valorPago;
    }


    /**
     * Sets the valorPago value for this RetornoStatusPagamento.
     * 
     * @param valorPago
     */
    public void setValorPago(java.lang.String valorPago) {
        this.valorPago = valorPago;
    }


    /**
     * Gets the nivelRisco value for this RetornoStatusPagamento.
     * 
     * @return nivelRisco
     */
    public java.lang.String getNivelRisco() {
        return nivelRisco;
    }


    /**
     * Sets the nivelRisco value for this RetornoStatusPagamento.
     * 
     * @param nivelRisco
     */
    public void setNivelRisco(java.lang.String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }


    /**
     * Gets the mensagem value for this RetornoStatusPagamento.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this RetornoStatusPagamento.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetornoStatusPagamento)) return false;
        RetornoStatusPagamento other = (RetornoStatusPagamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pedidoNumeroLoja==null && other.getPedidoNumeroLoja()==null) || 
             (this.pedidoNumeroLoja!=null &&
              this.pedidoNumeroLoja.equals(other.getPedidoNumeroLoja()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.modulo==null && other.getModulo()==null) || 
             (this.modulo!=null &&
              this.modulo.equals(other.getModulo()))) &&
            ((this.meioPagamento==null && other.getMeioPagamento()==null) || 
             (this.meioPagamento!=null &&
              this.meioPagamento.equals(other.getMeioPagamento()))) &&
            ((this.dataPagamento==null && other.getDataPagamento()==null) || 
             (this.dataPagamento!=null &&
              this.dataPagamento.equals(other.getDataPagamento()))) &&
            ((this.valorPago==null && other.getValorPago()==null) || 
             (this.valorPago!=null &&
              this.valorPago.equals(other.getValorPago()))) &&
            ((this.nivelRisco==null && other.getNivelRisco()==null) || 
             (this.nivelRisco!=null &&
              this.nivelRisco.equals(other.getNivelRisco()))) &&
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
        if (getPedidoNumeroLoja() != null) {
            _hashCode += getPedidoNumeroLoja().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getModulo() != null) {
            _hashCode += getModulo().hashCode();
        }
        if (getMeioPagamento() != null) {
            _hashCode += getMeioPagamento().hashCode();
        }
        if (getDataPagamento() != null) {
            _hashCode += getDataPagamento().hashCode();
        }
        if (getValorPago() != null) {
            _hashCode += getValorPago().hashCode();
        }
        if (getNivelRisco() != null) {
            _hashCode += getNivelRisco().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetornoStatusPagamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "RetornoStatusPagamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedidoNumeroLoja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PedidoNumeroLoja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Modulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("meioPagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MeioPagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPagamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataPagamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ValorPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelRisco");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NivelRisco"));
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
