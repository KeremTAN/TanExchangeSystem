package Models.StrategyMoney;

import Models.EMoney;
import Models.Markets.MarketsOfMoney;

public class ChfMoneyExch implements IExchangeMoney{
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity* MarketsOfMoney.getCHF();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/MarketsOfMoney.getCHF();
    }

    @Override
    public double getMoneyValue() {
        return MarketsOfMoney.getCHF();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.CHF;
    }
}
