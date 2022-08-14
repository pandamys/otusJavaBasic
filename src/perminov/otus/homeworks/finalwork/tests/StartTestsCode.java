package perminov.otus.homeworks.finalwork.tests;

public class StartTestsCode {
    public static void main(String[] args) {
        PriceInWordsTests priceInWordsTests = new PriceInWordsTests();
        priceInWordsTests.testOutput();
        priceInWordsTests.testNull();
        priceInWordsTests.testCurrency();
        priceInWordsTests.testConvertNumberToString();
        priceInWordsTests.testCorrectCurrencyForm();
    }
}
