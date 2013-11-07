/**
 * TestServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mycompany.service;

public interface TestServiceService extends javax.xml.rpc.Service {
    public java.lang.String getTestServicePortAddress();

    public com.mycompany.service.TestService getTestServicePort() throws javax.xml.rpc.ServiceException;

    public com.mycompany.service.TestService getTestServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
