package Models.StrategyMoney;

import Models.EMoney;
import Models.Markets.MarketsOfMoney;

public class UsdMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity* MarketsOfMoney.getUSD();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/MarketsOfMoney.getUSD();
    }

    @Override
    public double getMoneyValue() {
        return MarketsOfMoney.getUSD();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.USD;
    }
}
