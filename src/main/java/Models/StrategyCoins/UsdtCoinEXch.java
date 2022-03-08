package Models.StrategyCoins;

import Models.Markets.ECoins;

public class UsdtCoinEXch implements IExchangeCoins{
    @Override
    public double convertToUSDT(double coinQuantity) {
        return coinQuantity*ECoins.getUSDT();
    }

    @Override
    public double convertToCoin(double usdtQuantity) {
        return usdtQuantity/ECoins.getUSDT();
    }

    @Override
    public double getCoinValue() {
        return ECoins.getUSDT();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.USDT;
    }
}
