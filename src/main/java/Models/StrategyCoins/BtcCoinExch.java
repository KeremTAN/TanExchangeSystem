package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;
public class BtcCoinExch implements IExchangeCoins{
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*MarketsOfCoins.getBTC();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/MarketsOfCoins.getBTC();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getBTC();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BTC;
    }
}
