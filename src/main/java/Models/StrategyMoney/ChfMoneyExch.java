package Models.StrategyMoney;

import Models.Markets.EMoney;

class ChfMoneyExch implements IExchangeMoney{
    @Override
    public double convertToTRY(double currencyQuantity) {
        return currencyQuantity* EMoney.getCHF();
    }

    @Override
    public double convertToCurrency(double tryQuantity) {
        return tryQuantity/EMoney.getCHF();
    }

    @Override
    public double getMoneyValue() {
        return EMoney.getCHF();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.CHF;
    }
}
