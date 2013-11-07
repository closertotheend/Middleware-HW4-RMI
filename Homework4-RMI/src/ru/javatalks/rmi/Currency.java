package ru.javatalks.rmi;

public enum Currency {
	EUR {
		@Override
		public double getToUSDExchangeRate() {
			return 1.37f;
		}
	},
	USD {
		@Override
		public double getToUSDExchangeRate() {
			return 1f;
		}
	},
	GBP {
		@Override
		public double getToUSDExchangeRate() {
			return 1.60f;
		}
	};
	public abstract double getToUSDExchangeRate();

	public double convertTo(double amount,
			Currency currencyToWhichConvert) {
		return this.getToUSDExchangeRate() * amount
				/ currencyToWhichConvert.getToUSDExchangeRate();
	};
}
