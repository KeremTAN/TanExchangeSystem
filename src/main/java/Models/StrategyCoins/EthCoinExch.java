package Models.StrategyCoins;

import Models.Markets.ECoins;
//import Models.Markets.MarketsOfCoins;
public class EthCoinExch implements  IExchangeCoins {
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*ECoins.getETH();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getETH();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getETH();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ETH;
    }
}
