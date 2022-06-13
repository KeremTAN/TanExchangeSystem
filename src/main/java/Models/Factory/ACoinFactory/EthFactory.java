package Models.Factory.ACoinFactory;

import Models.Markets.ECoins;
import Models.StrategyCoins.EthCoinExch;
import Models.StrategyCoins.IExchangeCoins;

public class EthFactory implements ICoinFactory{
    @Override
    public IExchangeCoins createCoin() {
        return new EthCoinExch();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ETH;
    }
}
