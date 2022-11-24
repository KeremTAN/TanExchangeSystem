package Models.StrategyConvert.CoinConverter;

public class ConvertToUsdt implements IConverterCoin{
    @Override
    public double convert(double coinPrice, double coinQuantity) {
        return coinPrice*coinQuantity;
    }
}
