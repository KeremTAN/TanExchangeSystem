package Models.StrategyMoney;

import Models.Markets.EMoney;


class UsdMoneyExch implements IExchangeMoney {
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity*EMoney.getUSD();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/EMoney.getUSD();
    }

    @Override
    public double getMoneyValue() {
        return EMoney.getUSD();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.USD;
    }
}
