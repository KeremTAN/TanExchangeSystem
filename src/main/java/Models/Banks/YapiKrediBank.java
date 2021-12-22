package Models.Banks;

import Models.EMoney;
import java.util.HashMap;
import java.util.Map;

public class YapiKrediBank extends ABanks {
    private final String name="Yapı Kredi Bankası";
    private static Map<EMoney,Double> allReserveMoney = new HashMap<>();
    private double bankCommission=0.006;
    private static double moneyOfBank=0.0; // TRY
    private static YapiKrediBank instance;

    private YapiKrediBank(){
        allReserveMoney.put(EMoney.TRY, 560873100.0);
        allReserveMoney.put(EMoney.USD, 75000058.0);
        allReserveMoney.put(EMoney.EUR, 82087500.0);
        allReserveMoney.put(EMoney.GBP, 38405000.0);
        allReserveMoney.put(EMoney.CHF, 12000870.0);
        allReserveMoney.put(EMoney.Gold, 500.0); // quantity
        allReserveMoney.put(EMoney.Silver, 1500.0); // quantity
    }

    public static YapiKrediBank getInstance() {
        if (instance==null) {
            synchronized (YapiKrediBank.class) {
                instance = new YapiKrediBank();
            }
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected Map<EMoney, Double> getAllReserveMoney() {
        return allReserveMoney;
    }

    @Override
    protected double getBankCommission() {
        return bankCommission;
    }

    @Override
    protected double getMoneyBank() {
        return moneyOfBank;
    }

    @Override
    protected void updateBankMoney() {
        moneyOfBank+=getGainOfBank();
    }
}
