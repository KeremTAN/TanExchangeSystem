package Models.StrategyMoney.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.*;

public class EurFactory implements IMoneyFactory{
    @Override
    public IExchangeMoney createMoney() {
        return new EurMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.EUR;
    }
}
