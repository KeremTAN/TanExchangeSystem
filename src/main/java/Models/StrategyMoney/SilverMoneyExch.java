package Models.StrategyMoney;

import Models.Markets.EMoney;


class SilverMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return (currencyQuantity)* EMoney.getSilver();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return (tryQuantity)/(EMoney.getSilver());
    }

    @Override
    public double getMoneyValue() {
        return EMoney.getSilver();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.Silver;
    }
}
