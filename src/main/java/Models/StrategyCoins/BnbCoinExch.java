package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;
public class BnbCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*MarketsOfCoins.getBNB();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/MarketsOfCoins.getBNB();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getBNB();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BNB;
    }
}
