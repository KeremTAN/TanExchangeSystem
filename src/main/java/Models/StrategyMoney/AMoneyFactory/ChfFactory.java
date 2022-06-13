package Models.StrategyMoney.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.ChfMoneyExch;
import Models.StrategyMoney.IExchangeMoney;

public class ChfFactory implements IMoneyFactory{
    @Override
    public IExchangeMoney createMoney() {
        return new ChfMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.CHF;
    }
}
