package Models.StrategyMoney.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.GbpMoneyExch;
import Models.StrategyMoney.IExchangeMoney;

public class GbpFactory implements IMoneyFactory{
    @Override
    public IExchangeMoney createMoney() {
        return new GbpMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.GBP;
    }
}
