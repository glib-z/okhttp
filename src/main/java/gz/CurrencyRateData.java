package gz;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRateData {

    private String date;
    private String bank;
    private int baseCurrency;
    private String baseCurrencyLit;
    private List<CurrencyRate> exchangeRate = new ArrayList<CurrencyRate>();

    public String getDate() {
        return date;
    }

    public String getBank() {
        return bank;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public List<CurrencyRate> getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "CurrencyRateData{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + exchangeRate +
                "\n}";
    }
}
