package Models.StrategyMoney;

import Models.Markets.EMoney;

class EurMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity*EMoney.getEUR();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/EMoney.getEUR();
    }

    @Override
    public double getMoneyValue() {
        return EMoney.getEUR();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.EUR;
    }
}
