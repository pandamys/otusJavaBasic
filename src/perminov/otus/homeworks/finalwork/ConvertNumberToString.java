package perminov.otus.homeworks.finalwork;

public class ConvertNumberToString implements Converter{

    @Override
    public String convert(String currency, Integer number) {
        String resultString, numberStr;
        String form = getFormCurrency(currency, number);
        if (form == null){
            resultString = "Нет справочника для данной валюты!";
        } else {
            numberStr = calculatePartOfNumber(number);
            resultString = numberStr.trim() + " " + form;
        }
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

    public String calculatePartOfNumber(Integer number){
        String numberStr;
        if (number > 0 && number < 100) {
            numberStr = convertToString(number);
        } else if (number >= 100 && number < 1000){
            numberStr = "";
            Integer[] partsNumber = new Integer[]{number, number % 100};
            for (Integer part: partsNumber){
                numberStr += convertToString(part) + " ";
            }
        } else if (number >= 1000 && number < 1000000){
            Integer countThousand = number / 1000;
            numberStr = convertToString(countThousand) + getDeclensionThousand(countThousand) + calculatePartOfNumber(number % 1000);
        } else {
            numberStr = "";
        }
        return numberStr;
    }

    public String convertToString(Integer number){
        String[] formNumber;
        String s = null;
        if (number >= 0 && number <= 10){
            formNumber = new String[]{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять"};
            s = formNumber[number];
        } else if (number > 10 && number < 20){
            formNumber = new String[]{"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                    "семнадцать", "восемнадцать", "девятнадцать"};
            s = formNumber[getLastNumber(number)];
        } else if (number >= 20 && number < 100){
            formNumber = new String[]{"","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят", "девяносто"};
            if (number % 10 == 0) {
                number = number / 10 - 1;
                s = formNumber[number];
            } else {
                s = formNumber[number / 10 - 1] + " " + convertToString(number % 10);
            }
        } else if (number >= 100 && number < 1000){
            formNumber = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
            number = number / 100 - 1;
            s = formNumber[number];
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

    public String getDeclensionThousand(Integer countThousand){
        String form;


        if (countThousand == 1){
            form = " тысяча ";
        } else if (countThousand > 1 && countThousand < 5) {
            form = " тысячи ";
        } else if (countThousand >= 5 && countThousand <= 20){
            form = " тысяч ";
        } else if (countThousand > 20) {
            form = getDeclensionThousand(countThousand % 10);
        } else {
            form = " ";
        }
        return form;
    }
}
