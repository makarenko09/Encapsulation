//package org.skypro.skyshop.product;
//
//public class ExceptionOutFromRangeOfValueSumSymbolInStringName extends RuntimeException {
//    String name;
//
//    public ExceptionOutFromRangeOfValueSumSymbolInStringName(String name) {
//        super();
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Exc.OutFromRangeOfValueSumSymbolInStringName.toString{" +
//                "name='" + name + '\'' + "- имя товара должно быть от 2 до 20 символов\"" +
//                '}';
//    }
//
//    public boolean getExcDangerValueFromNameOfProduct() {
//
//        if (this.name.length() < 2 || this.name.length() > 20) {
//            System.out.println("exc.InLocalMethodErr");
//            throw new IllegalArgumentException(name);
//        }
//
//
//        return false;
//    }
//}
