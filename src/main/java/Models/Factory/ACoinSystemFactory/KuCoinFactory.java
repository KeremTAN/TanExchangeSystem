package Models.Factory.ACoinSystemFactory;

import Models.CoinSystems.ACoinSystem;
import Models.CoinSystems.KuCoin;

public class KuCoinFactory implements  ICoinSystemFactory{
    @Override
    public ACoinSystem createCoinSystem() {
        return KuCoin.getInstance();
    }
}
