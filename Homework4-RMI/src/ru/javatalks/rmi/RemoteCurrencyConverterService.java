package ru.javatalks.rmi;

import java.rmi.*;

public interface RemoteCurrencyConverterService extends Remote {

	double convert(Currency from, Currency to, double amount) throws RemoteException;
}