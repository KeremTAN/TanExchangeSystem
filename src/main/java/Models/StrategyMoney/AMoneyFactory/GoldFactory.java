package Models.StrategyMoney.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.GoldMoneyExch;
import Models.StrategyMoney.IExchangeMoney;

public class GoldFactory implements IMoneyFactory{
    @Override
    public IExchangeMoney createMoney() {
        return new GoldMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.Gold;
    }
}
