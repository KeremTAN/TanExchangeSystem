package Models.StrategyConvert.MoneyConverter;

import Models.StrategyConvert.MoneyConverter.IConvertMoney;

public class ConvertToCurrency implements IConvertMoney {
    @Override
    public double convert(double currencyMoney, double tryQuantity) {
        return tryQuantity/currencyMoney;
    }
}
