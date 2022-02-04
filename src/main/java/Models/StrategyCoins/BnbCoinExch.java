package Models.StrategyCoins;

import Models.Markets.ECoins;
//import Models.Markets.MarketsOfCoins;
public class BnbCoinExch implements IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*ECoins.getBNB();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getBNB();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getBNB();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BNB;
    }
}
