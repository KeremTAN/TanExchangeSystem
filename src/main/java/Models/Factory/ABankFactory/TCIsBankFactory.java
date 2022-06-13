package Models.Factory.ABankFactory;

import Models.Banks.ABanks;
import Models.Banks.TurkiyeCumIsBank;

public class TCIsBankFactory implements IBankFactory {
    @Override
    public ABanks createBank() {
        return TurkiyeCumIsBank.getInstance();
    }
}
