package Models.Customer.StrategyTransaction.BanksTransaction;

import Models.Banks.ABanks;
import Models.Customer.Customer;
import Models.Customer.StrategyTransaction.ITransaction;
import Models.Markets.EMoney;

import java.text.DecimalFormat;

public interface IBankTransaction extends ITransaction {
    void transaction(Customer cus, EMoney money, double quantity, ABanks processBank);
}
