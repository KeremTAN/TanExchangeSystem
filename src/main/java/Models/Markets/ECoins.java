package Models.Markets;

public enum ECoins {
    USDT(13.55), BTC(38500.865), BNB(450.48), ETH(15980.125), ALGO(1.05), ADA(0.8);

    private double price;

    ECoins(double price) {
        this.price=price;
    }

    public static double getUSDT() { return USDT.price; }

    public static double getBTC() {
        return BTC.price;
    }

    public static double getBNB() {
        return BNB.price;
    }

    public static double getETH() { return ETH.price; }

    public static double getALGO() {
        return ALGO.price;
    }

    public static double getADA() {
        return ADA.price;
    }
}

