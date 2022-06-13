package View;

import Controls.Facade;
import Models.Customer.Customer;
import Models.Customer.CustomerBuilder;
import Models.Factory.ACoinFactory.AlgoFactory;
import Models.Factory.ACoinSystemFactory.BinanceFactory;

public class App {
    public static void main(String[] args) {
        Facade facade = Facade.getInstance();
        Customer cus1 = CustomerBuilder.createCustomer("Steve", "JOBS", "9234567890", "5554443322", 'E')
                .setAge(47)
                .setHasCriminalRecord(true)
                .setIsMarried(true)
                .buildCustomer();

        Customer cus2 = CustomerBuilder.createGreatCustomer("BILL", "GATES", "1234567890", "1114443322", 'E')
                .setAge(53)
                .setEmailAddress("Bbill@hotmail.com")
                .buildCustomer();
        Customer[] allCustomers={ cus1, cus2};

        cus2.printGoodsAndChattelsOfCustomer();
        facade.customerBuysCoin(cus2, new BinanceFactory(),150, new AlgoFactory());
        cus2.printGoodsAndChattelsOfCustomer();
    }
}
