package Models.StrategyCoins;

import Models.Markets.ECoins;
//import Models.Markets.MarketsOfCoins;
public class BtcCoinExch implements IExchangeCoins{
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*ECoins.getBTC();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getBTC();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getBTC();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BTC;
    }
}
