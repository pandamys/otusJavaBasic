package perminov.otus.homeworks.finalwork;

public abstract class Currency {

    private final String name;
    private static final String supportCurrency = "рубль/доллар";

    public Currency(String name){
        this.name = name;
    }

    public abstract String[] getForms();

    public abstract void setForms(String[] forms);

    public String getName() {
        return this.name;
    }

    public static String getFormCurrency(Currency currency, Integer number){
        String[] formsCurrency;
        String form = null;

        if (currency != null){
            formsCurrency = currency.getForms();
            if (number > 20 && number < 100){
                number = getLastNumber(number, 10);
            } else {
                number = getLastNumber(number, 100);
                if (number > 20){
                    number = getLastNumber(number, 10);
                }
            }

            if (number == 0 || number >= 5 && number <= 20){
                form = formsCurrency[2];
            } else if (number == 1) {
                form = formsCurrency[0];
            } else if (number > 1 && number < 5){
                form = formsCurrency[1];
            }
            return form;
        }
        return null;
    }

    public static Currency getCurrency(String currencyName){
        Currency currency;
        switch (currencyName.toLowerCase()){
            case "рубль":
                currency = new Ruble(currencyName);
                break;
            case "доллар":
                currency = new Dollar(currencyName);
                break;
            default:
                throw new UnsupportedCurrencyException(currencyName);
        }
        return currency;
    }

    public static Integer getLastNumber(Integer i, Integer divider){
        return i % divider;
    }

    public static String getSupportedCurrency(){
        return supportCurrency;
    }
}
