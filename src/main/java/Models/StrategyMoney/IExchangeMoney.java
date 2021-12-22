package Models.StrategyMoney;

import Models.EMoney;

public interface IExchangeMoney {
    double convertToTRY(double currencyQuantity);
    double convertToCurrency(double tryQuantity);
    double getMoneyValue();
    EMoney getMoneyType();
}
