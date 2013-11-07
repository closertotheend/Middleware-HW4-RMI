package service;

public class TestServiceProxy implements service.TestService {
  private String _endpoint = null;
  private service.TestService testService = null;
  
  public TestServiceProxy() {
    _initTestServiceProxy();
  }
  
  public TestServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTestServiceProxy();
  }
  
  private void _initTestServiceProxy() {
    try {
      testService = (new service.TestServiceServiceLocator()).getTestServicePort();
      if (testService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)testService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)testService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (testService != null)
      ((javax.xml.rpc.Stub)testService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.TestService getTestService() {
    if (testService == null)
      _initTestServiceProxy();
    return testService;
  }
  
  public double sqrt(double arg0) throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.sqrt(arg0);
  }
  
  public java.lang.String getDate() throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.getDate();
  }
  
  public java.lang.String hello() throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.hello();
  }
  
  public double calculate(double arg0, double arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.calculate(arg0, arg1, arg2);
  }
  
  
}