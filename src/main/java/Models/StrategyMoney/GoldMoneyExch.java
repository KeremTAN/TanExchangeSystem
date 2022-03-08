package Models.StrategyMoney;

import Models.Markets.EMoney;


public class GoldMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return (currencyQuantity)*EMoney.getGold();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return (tryQuantity)/(EMoney.getGold());
    }

    @Override
    public double getMoneyValue() {
        return EMoney.getGold();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.Gold;
    }
}
