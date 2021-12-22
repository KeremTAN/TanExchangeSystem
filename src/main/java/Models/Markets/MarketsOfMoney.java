package Models.Markets;

public class MarketsOfMoney {
    private static double TRY=1;
    private static double USD=8.33;
    private static double EUR=9.96;
    private static double GBP=11.48;
    private static double CHF=9.06;
    private static double Gold=486.000; // for 1 gr
    private static double Silver=8.500; // for 1 gr

    public static double getTRY() {
        return TRY;
    }

    public static double getUSD() { return USD; }

    public static double getEUR() {
        return EUR;
    }

    public static double getGBP() {
        return GBP;
    }

    public static double getCHF() {
        return CHF;
    }

    public static double getGold() {
        return Gold;
    }

    public static double getSilver() {
        return Silver;
    }
}
