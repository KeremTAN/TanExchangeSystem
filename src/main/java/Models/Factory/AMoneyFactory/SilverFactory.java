package Models.Factory.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.IExchangeMoney;
import Models.StrategyMoney.SilverMoneyExch;

public class SilverFactory implements IMoneyFactory{
    @Override
    public IExchangeMoney getMoney() {
        return new SilverMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.Silver;
    }
}
