package Models.StrategyCoins;

import Models.Markets.ECoins;


public class AdaCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity* ECoins.getADA();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getADA();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getADA();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ADA;
    }
}
