package Models.Factory.ACoinFactory;

import Models.Markets.ECoins;
import Models.StrategyCoins.IExchangeCoins;
import Models.StrategyCoins.UsdtCoinEXch;

public class UsdtFactory implements ICoinFactory{
    @Override
    public IExchangeCoins createCoin() {
        return new UsdtCoinEXch();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.USDT;
    }
}
