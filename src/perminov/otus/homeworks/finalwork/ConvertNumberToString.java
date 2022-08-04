package perminov.otus.homeworks.finalwork;

public class ConvertNumberToString implements Converter {

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

        if (formsCurrency != null){
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

    public Integer getLastNumber(Integer i, Integer divider){
        return i % divider;
    }

    public String calculatePartOfNumber(Integer number){
        String numberStr;
        if (number > 0 && number < 1000) {
            numberStr = convertToString(number);
        } else if (number >= 1000 && number < 1000000){
            String thousand;
            Integer countThousand = number / 1000;
            thousand = replaceThousand(convertToString(countThousand));
            numberStr = thousand + getDeclension(countThousand, 1000) + calculatePartOfNumber(number % 1000);
        } else if (number >= 1000000 && number < 1000000000){
            Integer countMillion = number / 1000000;
            numberStr = convertToString(countMillion) + getDeclension(countMillion, 1000000) + calculatePartOfNumber(number % 1000000);
        } else {
            numberStr = "";
        }
        return numberStr;
    }

    public String replaceThousand(String thousand){
        if (thousand.contains("один")){
            thousand = thousand.replace("один", "одна");
        } else if (thousand.contains("два")){
            thousand = thousand.replace("два", "две");
        }
        return thousand;
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
            s = formNumber[getLastNumber(number, 10)];
        } else if (number >= 20 && number < 100){
            formNumber = new String[]{"","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят", "девяносто"};
            s = calculatePartNumber(number, 10, formNumber);
        } else if (number >= 100 && number < 1000){
            formNumber = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
            s = calculatePartNumber(number, 100, formNumber);
        }
        return s;
    }

    public String calculatePartNumber(Integer number, Integer divider, String[] formNumber){
        String s;
        if (number % divider == 0) {
            number = number / divider - 1;
            s = formNumber[number];
        } else {
            s = formNumber[number / divider - 1] + " " + convertToString(number % divider);
        }
        return s;
    }

    public String[] getDeclensionCurrency(String currency){
        String[] form;
        switch (currency.toLowerCase()){
            case "рубль":
                form = new String[]{"рубль","рубля","рублей"};
                break;
            case "доллар":
                form = new String[]{"доллар","доллара","долларов"};
                break;
            default:
                form = null;
                break;
        }
        return form;
    }

    public String getDeclension(Integer count, Integer type){
        String form = " ";

        if (count == 1){
            if (type == 1000) {
                form = " тысяча ";
            } else if (type == 1000000){
                form = " миллион ";
            }
        } else if (count > 1 && count < 5) {
            if (type == 1000) {
                form = " тысячи ";
            } else if (type == 1000000){
                form = " миллиона ";
            }
        } else if (count >= 5 && count <= 20 || count == 0){
            if (type == 1000) {
                form = " тысяч ";
            } else if (type == 1000000){
                form = " миллионов ";
            }
        } else if (count > 20) {
            form = getDeclension(count % 10, type);
        }
        return form;
    }
}
