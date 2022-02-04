package Models.StrategyCoins;

import Models.Markets.ECoins;
//import Models.Markets.MarketsOfCoins;
public class AlgoCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*ECoins.getALGO();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getALGO();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getALGO();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ALGO;
    }
}
