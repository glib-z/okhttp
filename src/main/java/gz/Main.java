package gz;

import com.google.gson.Gson;
import gz.utils.CurrCodeData;
import java.util.Scanner;

public class Main {

    private static CurrCodeData currCodeData = new CurrCodeData();

    public static void main(String[] args) {

        final String URL = "https://api.privatbank.ua/p24api/exchange_rates?json=true&date=";

        Scanner scanner = new Scanner(System.in);
        String date;
        do {
            System.out.print("Введите даду для отображения курса \"ДД.ММ.ГГГГ\": ");
            date = scanner.nextLine();
        } while (!checkDateFormat(date));

        long time = System.currentTimeMillis();
        // OkHttp
        String response = UseOkHttp.request(new StringBuilder().append(URL).append(date).toString(), true);
        time = System.currentTimeMillis() - time;
        System.out.println("Request time: " + time / 1000.0 + "s");

        if (UseOkHttp.status.compareTo("OK") == 0) {
            Gson gson = new Gson();
            CurrencyRateData currencyRateData = gson.fromJson(response, CurrencyRateData.class);

            // Checking of currencies exchange data available.
            if (!isCurrenciesAvailable(currencyRateData)) {
                return;
            }

            //
            System.out.print("Введите код валюты: ");
            String curr = scanner.nextLine();
            for (int i = 0; i < currencyRateData.getExchangeRate().size() - 1; i++) {
                if (currencyRateData.getExchangeRate().get(i).getCurrency() != null) {
                    if (curr.compareTo(currencyRateData.getExchangeRate().get(i).getCurrency()) == 0) {
                        System.out.println(currCodeData.getCurrencyDescription(curr) + ": " +
                                "\tПокупка " + currencyRateData.getExchangeRate().get(i).getSaleRateNB() +
                                " / Продажа " + currencyRateData.getExchangeRate().get(i).getPurchaseRateNB());
                    }
                }
            }

        } else {
            System.out.println("UseOkHttp.status: " + UseOkHttp.status);
        }

        scanner.close();

    }

    // Checks format of data (DD.MM.YYYY)
    private static boolean checkDateFormat(String date) {
        String[] s = date.split("\\.");
        int d = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int y= Integer.parseInt(s[2]);
        if ((date.length() ==10) && (s[0].length() == 2) && (s[1].length() == 2)) {
            if (d > 0 && d < 32) {
                if (m > 0 && m < 13){
                    if (y > 1990 && y < 2100) {
                        return true;
                    }
                }
            }
        }
        System.out.println("Формат введенной даты некорректен!");
        return false;
    }

    // Printing the available currencies
    private static Boolean isCurrenciesAvailable(CurrencyRateData currencyRateData) {
        if (currencyRateData.getExchangeRate().size() > 0) {
            System.out.print("Доступные валюты для отображения обменного курса: ");
            for (int i = 0; i < currencyRateData.getExchangeRate().size()-1; i++){
                if (currencyRateData.getExchangeRate().get(i).getCurrency() != null) {      // Some records comes without currency record
                    System.out.print(currencyRateData.getExchangeRate().get(i).getCurrency());
                    if (i < currencyRateData.getExchangeRate().size() -2) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(".");
            return true;
        } else {
            System.out.print("Данных для отображения курса валют нет.");
            return false;
        }
    }

}
