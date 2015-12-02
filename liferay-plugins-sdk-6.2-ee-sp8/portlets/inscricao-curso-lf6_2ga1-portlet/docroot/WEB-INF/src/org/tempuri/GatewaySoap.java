/**
 * GatewaySoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface GatewaySoap extends java.rmi.Remote {

    /**
     * Consulta os Meios de Pagamentos disponiveis para uma Loja
     */
    public org.tempuri.RetornoMeiosPagamento[] consultaMeiosDePagamento(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios) throws java.rmi.RemoteException;

    /**
     * Consulta os Meios de Pagamentos disponiveis para uma Loja
     */
    public java.lang.String consultaMeiosDePagamentoXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios) throws java.rmi.RemoteException;

    /**
     * Consulta os Meios de Pagamentos disponiveis para uma Loja Magento
     */
    public org.tempuri.RetornoMeiosPagamento consultaMeiosDePagamentoMagento(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor) throws java.rmi.RemoteException;

    /**
     * Consulta os Meios de Pagamentos disponiveis HTML
     */
    public java.lang.String consultaMeiosDePagamentoHTML(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor) throws java.rmi.RemoteException;

    /**
     * Consulta os Meios de Pagamentos disponiveis HTML
     */
    public java.lang.String consultaMeiosDePagamentoHTMLv2(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor, java.lang.String idioma) throws java.rmi.RemoteException;

    /**
     * Consulta os Valores das parcelas HTML
     */
    public java.lang.String consultaParcelasHTML(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException;

    /**
     * Consulta os Valores das parcelas Array
     */
    public org.tempuri.RetornoParcelas[] consultaParcelasArray(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException;

    /**
     * Consulta os Valores das parcelas Array
     */
    public java.lang.String consultaParcelasXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException;

    /**
     * Registra um pedido para ser pago pelo cliente em XML
     */
    public org.tempuri.RetornoPedido iniciarPagamento(java.lang.String pedidoXML) throws java.rmi.RemoteException;

    /**
     * Registra um pedido para ser pago pelo cliente em XML
     */
    public java.lang.String iniciarPagamentoXML(java.lang.String pedidoXML) throws java.rmi.RemoteException;

    /**
     * Retorna o status de um pedido
     */
    public org.tempuri.RetornoStatusPagamento consultaStatusPagamento(java.lang.String loja, java.lang.String aplicacao, java.lang.String pedido) throws java.rmi.RemoteException;

    /**
     * Retorna o status de um pedido
     */
    public java.lang.String consultaStatusPagamentoXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String pedido) throws java.rmi.RemoteException;
}
