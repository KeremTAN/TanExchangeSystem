package Models.CoinSystems;

import Models.Markets.ECoins;

import java.util.HashMap;
import java.util.Map;

public class KuCoin extends ACoinSystem {
    private final String name="KUCOIN";
    private static Map<ECoins,Double> allCoinsOnMarket = new HashMap<>();
    private double kuCoinCommission=0.00025;
    private static double moneyOfkuCoin=0.0; // Usdt
    private static KuCoin instance;

    private KuCoin() {
        allCoinsOnMarket.put(ECoins.USDT,7365840.0);
        allCoinsOnMarket.put(ECoins.BTC,1745.0);
        allCoinsOnMarket.put(ECoins.ETH,79855.0);
        allCoinsOnMarket.put(ECoins.BNB,305878.0);
        allCoinsOnMarket.put(ECoins.ALGO,565840.0);
        allCoinsOnMarket.put(ECoins.ADA,9565480.0);
    }

    public static KuCoin getInstance() {
        if (instance==null) {
            synchronized (KuCoin.class) {
                instance = new KuCoin();
            }
        }
        return instance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    protected Map<ECoins, Double> getAllCoinsOnMarket() {
        return allCoinsOnMarket;
    }

    @Override
    protected double getCoinSystemCommission() {
        return this.kuCoinCommission;
    }

    @Override
    protected double getMoneyOfCoinSystem() {
        return moneyOfkuCoin;
    }

    @Override
    protected void updateCoinSystemMoney() {
        moneyOfkuCoin+=getGainOfCoinSystem();
    }
}
