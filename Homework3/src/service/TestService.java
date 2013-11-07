/**
 * TestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface TestService extends java.rmi.Remote {
    public double sqrt(double arg0) throws java.rmi.RemoteException;
    public java.lang.String getDate() throws java.rmi.RemoteException;
    public java.lang.String hello() throws java.rmi.RemoteException;
    public double calculate(double arg0, double arg1, java.lang.String arg2) throws java.rmi.RemoteException;
}
