package client;

import java.rmi.registry.*;

import logic.Currency;
import logic.RemoteCurrencyConverterService;

public class HelloServiceClient {

	public static void main(String... args) throws Exception {
		Registry registry = LocateRegistry.getRegistry("localhost", 2099);
		RemoteCurrencyConverterService service = (RemoteCurrencyConverterService) registry
				.lookup("test/Converter");
		System.out.println(service.convert(Currency.EUR, Currency.USD, 100));
	}

}