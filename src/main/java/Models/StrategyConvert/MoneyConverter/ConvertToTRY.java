package Models.StrategyConvert.MoneyConverter;

import Models.StrategyConvert.MoneyConverter.IConvertMoney;

public class ConvertToTRY implements IConvertMoney {
    @Override
    public double convert(double currencyMoney, double currencyQuantity) {
        return currencyMoney*currencyQuantity;
    }
}
