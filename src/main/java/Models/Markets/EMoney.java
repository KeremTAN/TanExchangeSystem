package Models.Markets;

public enum EMoney {
    TRY(1.0), EUR(15.85), USD(13.55), GBP(18.2), CHF(13.8), Gold(300.8), Silver(102.0);

    private double price;

    EMoney(double price) {
        this.price = price;
    }

    public static double getTRY() { return TRY.price; }

    public static double getEUR() { return EUR.price; }

    public static double getUSD() { return USD.price; }

    public static double getGBP() { return GBP.price; }

    public static double getCHF() { return CHF.price; }

    public static double getGold() { return Gold.price; }

    public static double getSilver() { return Silver.price; }
}