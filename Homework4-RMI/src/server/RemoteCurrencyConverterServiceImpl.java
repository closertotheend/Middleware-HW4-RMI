package server;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

import logic.Currency;
import logic.RemoteCurrencyConverterService;

public class RemoteCurrencyConverterServiceImpl implements
		RemoteCurrencyConverterService {

	public static final String BINDING_NAME = "test/Converter";

	public static void main(String... args) throws Exception {
		final Registry registry = LocateRegistry.createRegistry(2099);
		final RemoteCurrencyConverterService service = new RemoteCurrencyConverterServiceImpl();
		Remote stub = UnicastRemoteObject.exportObject(service, 0);
		registry.bind(BINDING_NAME, stub);
		while (true) {
			Thread.sleep(Integer.MAX_VALUE);
		}
	}

	@Override
	public double convert(Currency from, Currency to, double amount) {
		return from.convertTo(amount, to);
	}
}