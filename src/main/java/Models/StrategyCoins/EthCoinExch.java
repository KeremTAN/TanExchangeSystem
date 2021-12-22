package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;
public class EthCoinExch implements  IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*MarketsOfCoins.getETH();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/MarketsOfCoins.getETH();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getETH();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ETH;
    }
}
