
import java.rmi.*;

import logic.Currency;

public interface RemoteCurrencyConverterService extends Remote {

	double convert(Currency from, Currency to, double amount)
			throws RemoteException;
}