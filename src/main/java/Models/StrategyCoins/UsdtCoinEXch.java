package Models.StrategyCoins;

import Models.ECoins;
import Models.Markets.MarketsOfCoins;
public class UsdtCoinEXch implements IExchangeCoins{
/*    @Override
    public double convertToTRY(double currencyQuantity) { //usdt to try
        return currencyQuantity*MarketsOfCoins.getUSDT();
    }*/
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*MarketsOfCoins.getUSDT();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {

        return usdtQuantity/MarketsOfCoins.getUSDT();
    }

    @Override
    public double getCoinValue() {
        return MarketsOfCoins.getUSDT();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.USDT;
    }
}
