/**
 * GatewayLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GatewayLocator extends org.apache.axis.client.Service implements org.tempuri.Gateway {

    public GatewayLocator() {
    }


    public GatewayLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GatewayLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GatewaySoap
    private java.lang.String GatewaySoap_address = "https://moedadigital.net/Gateway.asmx";

    public java.lang.String getGatewaySoapAddress() {
        return GatewaySoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GatewaySoapWSDDServiceName = "GatewaySoap";

    public java.lang.String getGatewaySoapWSDDServiceName() {
        return GatewaySoapWSDDServiceName;
    }

    public void setGatewaySoapWSDDServiceName(java.lang.String name) {
        GatewaySoapWSDDServiceName = name;
    }

    public org.tempuri.GatewaySoap getGatewaySoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GatewaySoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGatewaySoap(endpoint);
    }

    public org.tempuri.GatewaySoap getGatewaySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.GatewaySoapStub _stub = new org.tempuri.GatewaySoapStub(portAddress, this);
            _stub.setPortName(getGatewaySoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGatewaySoapEndpointAddress(java.lang.String address) {
        GatewaySoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.GatewaySoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.GatewaySoapStub _stub = new org.tempuri.GatewaySoapStub(new java.net.URL(GatewaySoap_address), this);
                _stub.setPortName(getGatewaySoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GatewaySoap".equals(inputPortName)) {
            return getGatewaySoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Gateway");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "GatewaySoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GatewaySoap".equals(portName)) {
            setGatewaySoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
