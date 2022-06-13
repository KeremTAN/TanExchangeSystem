package Models.StrategyMoney.AMoneyFactory;

import Models.Markets.EMoney;
import Models.StrategyMoney.IExchangeMoney;

public interface IMoneyFactory {
    IExchangeMoney createMoney();
    EMoney getMoneyType();
}
