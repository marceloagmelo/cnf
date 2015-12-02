/**
 * RetornoPedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class RetornoPedido  implements java.io.Serializable {
    private java.lang.String NSU;

    private java.lang.String mensagem;

    private java.lang.String retorno;

    private java.lang.String pedidoStatus;

    private java.lang.String conteudo;

    private java.lang.String pedidoNumeroLoja;

    public RetornoPedido() {
    }

    public RetornoPedido(
           java.lang.String NSU,
           java.lang.String mensagem,
           java.lang.String retorno,
           java.lang.String pedidoStatus,
           java.lang.String conteudo,
           java.lang.String pedidoNumeroLoja) {
           this.NSU = NSU;
           this.mensagem = mensagem;
           this.retorno = retorno;
           this.pedidoStatus = pedidoStatus;
           this.conteudo = conteudo;
           this.pedidoNumeroLoja = pedidoNumeroLoja;
    }


    /**
     * Gets the NSU value for this RetornoPedido.
     * 
     * @return NSU
     */
    public java.lang.String getNSU() {
        return NSU;
    }


    /**
     * Sets the NSU value for this RetornoPedido.
     * 
     * @param NSU
     */
    public void setNSU(java.lang.String NSU) {
        this.NSU = NSU;
    }


    /**
     * Gets the mensagem value for this RetornoPedido.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this RetornoPedido.
     * 
     * @param mensagem
     */
    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the retorno value for this RetornoPedido.
     * 
     * @return retorno
     */
    public java.lang.String getRetorno() {
        return retorno;
    }


    /**
     * Sets the retorno value for this RetornoPedido.
     * 
     * @param retorno
     */
    public void setRetorno(java.lang.String retorno) {
        this.retorno = retorno;
    }


    /**
     * Gets the pedidoStatus value for this RetornoPedido.
     * 
     * @return pedidoStatus
     */
    public java.lang.String getPedidoStatus() {
        return pedidoStatus;
    }


    /**
     * Sets the pedidoStatus value for this RetornoPedido.
     * 
     * @param pedidoStatus
     */
    public void setPedidoStatus(java.lang.String pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }


    /**
     * Gets the conteudo value for this RetornoPedido.
     * 
     * @return conteudo
     */
    public java.lang.String getConteudo() {
        return conteudo;
    }


    /**
     * Sets the conteudo value for this RetornoPedido.
     * 
     * @param conteudo
     */
    public void setConteudo(java.lang.String conteudo) {
        this.conteudo = conteudo;
    }


    /**
     * Gets the pedidoNumeroLoja value for this RetornoPedido.
     * 
     * @return pedidoNumeroLoja
     */
    public java.lang.String getPedidoNumeroLoja() {
        return pedidoNumeroLoja;
    }


    /**
     * Sets the pedidoNumeroLoja value for this RetornoPedido.
     * 
     * @param pedidoNumeroLoja
     */
    public void setPedidoNumeroLoja(java.lang.String pedidoNumeroLoja) {
        this.pedidoNumeroLoja = pedidoNumeroLoja;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetornoPedido)) return false;
        RetornoPedido other = (RetornoPedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.NSU==null && other.getNSU()==null) || 
             (this.NSU!=null &&
              this.NSU.equals(other.getNSU()))) &&
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
            ((this.retorno==null && other.getRetorno()==null) || 
             (this.retorno!=null &&
              this.retorno.equals(other.getRetorno()))) &&
            ((this.pedidoStatus==null && other.getPedidoStatus()==null) || 
             (this.pedidoStatus!=null &&
              this.pedidoStatus.equals(other.getPedidoStatus()))) &&
            ((this.conteudo==null && other.getConteudo()==null) || 
             (this.conteudo!=null &&
              this.conteudo.equals(other.getConteudo()))) &&
            ((this.pedidoNumeroLoja==null && other.getPedidoNumeroLoja()==null) || 
             (this.pedidoNumeroLoja!=null &&
              this.pedidoNumeroLoja.equals(other.getPedidoNumeroLoja())));
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
        if (getNSU() != null) {
            _hashCode += getNSU().hashCode();
        }
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getRetorno() != null) {
            _hashCode += getRetorno().hashCode();
        }
        if (getPedidoStatus() != null) {
            _hashCode += getPedidoStatus().hashCode();
        }
        if (getConteudo() != null) {
            _hashCode += getConteudo().hashCode();
        }
        if (getPedidoNumeroLoja() != null) {
            _hashCode += getPedidoNumeroLoja().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetornoPedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "RetornoPedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSU");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NSU"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Retorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedidoStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PedidoStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conteudo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Conteudo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedidoNumeroLoja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PedidoNumeroLoja"));
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
