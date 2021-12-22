package Models.StrategyMoney;

import Models.EMoney;
import Models.Markets.MarketsOfMoney;
public class GoldMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return (currencyQuantity)*MarketsOfMoney.getGold();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return (tryQuantity)/(MarketsOfMoney.getGold());
    }

    @Override
    public double getMoneyValue() {
        return MarketsOfMoney.getGold();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.Gold;
    }
}
