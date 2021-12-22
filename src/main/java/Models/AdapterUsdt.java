package Models;

import Models.Markets.MarketsOfCoins;
import Models.StrategyCoins.UsdtCoinEXch;
import Models.StrategyMoney.IExchangeMoney;

public class AdapterUsdt implements IExchangeMoney {
    private UsdtCoinEXch adapteeUsdt;

    public AdapterUsdt(UsdtCoinEXch usdt) {
        adapteeUsdt=usdt;
    }

    @Override
    public double convertToTRY(double  usdtQuantity) {
       return adapteeUsdt.convertToUSDT(usdtQuantity);
    }

    @Override
    public double convertToCurrency(double tryQuantity) { // toUsdt
        return adapteeUsdt.convertToCoin(tryQuantity);
    }

    @Override
    public double getMoneyValue() {
        return MarketsOfCoins.getUSDT();
    }

    @Override
    public EMoney getMoneyType() {
        return null;
    }
}
