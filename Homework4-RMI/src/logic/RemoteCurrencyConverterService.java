package logic;

import java.rmi.*;

public interface RemoteCurrencyConverterService extends Remote {

	double convert(Currency from, Currency to, double amount) throws RemoteException;
}