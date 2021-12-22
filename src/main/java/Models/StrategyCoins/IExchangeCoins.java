package Models.StrategyCoins;

import Models.ECoins;
public interface IExchangeCoins {
    //double convertToTRY(double currencyQuantity);
    double convertToUSDT(double coinQuantity);
    double convertToCoin(double usdtQuantity);
    double getCoinValue();
    ECoins getCoinType();
}
