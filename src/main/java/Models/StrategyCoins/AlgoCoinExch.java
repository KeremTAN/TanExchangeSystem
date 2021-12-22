package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;
public class AlgoCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*MarketsOfCoins.getALGO();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/MarketsOfCoins.getALGO();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getALGO();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ALGO;
    }
}
