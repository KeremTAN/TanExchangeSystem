package Models.StrategyMoney;

import Models.EMoney;
import Models.Markets.MarketsOfMoney;
public class EurMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity*MarketsOfMoney.getEUR();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/MarketsOfMoney.getEUR();
    }

    @Override
    public double getMoneyValue() {
        return MarketsOfMoney.getEUR();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.EUR;
    }
}
