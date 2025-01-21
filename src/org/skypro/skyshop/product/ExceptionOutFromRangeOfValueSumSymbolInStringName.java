package org.skypro.skyshop.product;

public class ExceptionOutFromRangeOfValueSumSymbolInStringName extends RuntimeException {
    String name;

    public ExceptionOutFromRangeOfValueSumSymbolInStringName(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Exc.OutFromRangeOfValueSumSymbolInStringName.toString{" +
                "name='" + name + '\'' + "- имя товара должно быть от 2 до 20 символов\"" +
                '}';
    }

    public void getExcDangerValueFromNameOfProduct() throws ExceptionOutFromRangeOfValueSumSymbolInStringName {

        if (this.name.length() < 2 || this.name.length() > 20) {
throw new ExceptionOutFromRangeOfValueSumSymbolInStringName(name);
        }
           }
}
