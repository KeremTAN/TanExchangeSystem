package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;

public class AdaCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity* MarketsOfCoins.getADA();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/MarketsOfCoins.getADA();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getADA();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ADA;
    }
}
