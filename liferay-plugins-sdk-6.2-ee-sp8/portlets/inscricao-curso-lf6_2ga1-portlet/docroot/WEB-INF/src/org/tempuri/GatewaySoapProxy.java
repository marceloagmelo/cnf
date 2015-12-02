package org.tempuri;

public class GatewaySoapProxy implements org.tempuri.GatewaySoap {
  private String _endpoint = null;
  private org.tempuri.GatewaySoap gatewaySoap = null;
  
  public GatewaySoapProxy() {
    _initGatewaySoapProxy();
  }
  
  public GatewaySoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initGatewaySoapProxy();
  }
  
  private void _initGatewaySoapProxy() {
    try {
      gatewaySoap = (new org.tempuri.GatewayLocator()).getGatewaySoap();
      if (gatewaySoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)gatewaySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)gatewaySoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (gatewaySoap != null)
      ((javax.xml.rpc.Stub)gatewaySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.GatewaySoap getGatewaySoap() {
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap;
  }
  
  public org.tempuri.RetornoMeiosPagamento[] consultaMeiosDePagamento(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaMeiosDePagamento(loja, aplicacao, meios);
  }
  
  public java.lang.String consultaMeiosDePagamentoXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaMeiosDePagamentoXML(loja, aplicacao, meios);
  }
  
  public org.tempuri.RetornoMeiosPagamento consultaMeiosDePagamentoMagento(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaMeiosDePagamentoMagento(loja, aplicacao, meios, valor);
  }
  
  public java.lang.String consultaMeiosDePagamentoHTML(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaMeiosDePagamentoHTML(loja, aplicacao, meios, valor);
  }
  
  public java.lang.String consultaMeiosDePagamentoHTMLv2(java.lang.String loja, java.lang.String aplicacao, java.lang.String meios, java.lang.String valor, java.lang.String idioma) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaMeiosDePagamentoHTMLv2(loja, aplicacao, meios, valor, idioma);
  }
  
  public java.lang.String consultaParcelasHTML(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaParcelasHTML(loja, aplicacao, valor);
  }
  
  public org.tempuri.RetornoParcelas[] consultaParcelasArray(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaParcelasArray(loja, aplicacao, valor);
  }
  
  public java.lang.String consultaParcelasXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String valor) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaParcelasXML(loja, aplicacao, valor);
  }
  
  public org.tempuri.RetornoPedido iniciarPagamento(java.lang.String pedidoXML) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.iniciarPagamento(pedidoXML);
  }
  
  public java.lang.String iniciarPagamentoXML(java.lang.String pedidoXML) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.iniciarPagamentoXML(pedidoXML);
  }
  
  public org.tempuri.RetornoStatusPagamento consultaStatusPagamento(java.lang.String loja, java.lang.String aplicacao, java.lang.String pedido) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaStatusPagamento(loja, aplicacao, pedido);
  }
  
  public java.lang.String consultaStatusPagamentoXML(java.lang.String loja, java.lang.String aplicacao, java.lang.String pedido) throws java.rmi.RemoteException{
    if (gatewaySoap == null)
      _initGatewaySoapProxy();
    return gatewaySoap.consultaStatusPagamentoXML(loja, aplicacao, pedido);
  }
  
  
}