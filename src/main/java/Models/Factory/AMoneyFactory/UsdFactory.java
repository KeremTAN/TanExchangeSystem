package Models.Factory.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.*;

public class UsdFactory implements IMoneyFactory{
    
    @Override
    public IExchangeMoney createMoney() {
        return new UsdMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.USD;
    }
}
