package Models.Factory.ABankFactory;

import Models.Banks.ABanks;
import Models.Banks.YapiKrediBank;

public class YapiKrdBnkFactory implements IBankFactory{
    @Override
    public ABanks createBank() {
        return YapiKrediBank.getInstance();
    }
}
