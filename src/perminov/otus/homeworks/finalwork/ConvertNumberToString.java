package perminov.otus.homeworks.finalwork;

public class ConvertNumberToString implements Converter{

    @Override
    public String convert(String currency, Integer number) {
        String resultString = "не определено";
        String form = getFormCurrency(currency, number);

        resultString = number + " " + form;
        return resultString;
    }

    public String getFormCurrency(String currency, Integer number){
        String[] formsCurrency;
        String form = null;
        formsCurrency = getDeclensionCurrency(currency);

        if (currency.equalsIgnoreCase("рубли")){
            if (number > 20){
                number = getLastNumber(number);
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

    public Integer getLastNumber(Integer i){
        return i%10;
    }

    public String convertToString(Integer number){
        String numberString = "не определено";

        return numberString;
    }

    public String numberString(Integer number){
        String s = null;
        switch (number){
            case 1:
                s = "один";
                break;
            case 2:
                s = "два";
                break;
            case 3:
                s = "три";
                break;
            case 4:
                s = "четыре";
                break;
            case 5:
                s = "пять";
                break;
            case 6:
                s = "шесть";
                break;
            case 7:
                s = "семь";
                break;
            case 8:
                s = "восемь";
                break;
            case 9:
                s = "девять";
                break;
            case 10:
                s = "десять";
                break;
        }
        return s;
    }

    public String[] getDeclensionCurrency(String currency){
        String[] form;
        if (currency.equalsIgnoreCase("рубли")){
            form = new String[]{"рубль","рубля","рублей"};
        } else {
            form = null;
        }
        return form;
    }
}
