package Models.Factory.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.*;

public class UsdFactory implements IMoneyFactory{
    
    @Override
    public IExchangeMoney getMoney() {
        return new UsdMoneyExch();
    }

    @Override
    public EMoney getMoneyType() {
        return EMoney.USD;
    }
}
