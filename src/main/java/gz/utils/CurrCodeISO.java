package gz.utils;

public class CurrCodeISO {

    private String literal;
    private int code;
    private String description;

    public CurrCodeISO(String literal, int code, String description) {
        this.literal = literal;
        this.code = code;
        this.description = description;
    }

    public String getLiteral() {
        return literal;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
