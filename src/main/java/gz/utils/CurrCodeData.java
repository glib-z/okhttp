package gz.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CurrCodeData {

    private final String filename = "Коды валют по ISO 4217";
    List<CurrCodeISO> currCodes = new ArrayList<CurrCodeISO>();

    public CurrCodeData() {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String s;

            while ((s = br.readLine()) != null) {
                String[] currency = s.split("\t");
                if (currency.length == 3) {             // Strings with currency description have only two TAB dividers
                    if (currency[0].length() == 3 && currency[0].length() == 3) {
                        currCodes.add(new CurrCodeISO(currency[0], Integer.parseInt(currency[1]), currency[2]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("FileInputStream error");
        }
    }

    /**
     * Returns description of the specified currency
     * @param code The literal code of a currency
     * @return description of the specified currency
     */
    public String getCurrencyDescription(String code) {
        for (int i = 0; i < currCodes.size(); i++) {
            if (currCodes.get(i).getLiteral().compareTo(code) == 0) {
                return currCodes.get(i).getDescription();
            }
        }
        return "Нименование валюты для буквенного кода [" + code + "] не найдено";
    }

}
