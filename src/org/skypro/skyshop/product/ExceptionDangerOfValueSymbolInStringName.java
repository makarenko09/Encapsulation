package org.skypro.skyshop.product;

public class ExceptionDangerOfValueSymbolInStringName extends RuntimeException{
    String name;

    public ExceptionDangerOfValueSymbolInStringName(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Exc.DangerOfValueSymbolInStringName.toString{" +
                "name='" + name +"' - неправильное название для продукта.\""+ '\'' +
                '}';
    }

    public void getExcSpace() throws ExceptionDangerOfValueSymbolInStringName {
        if (name.isBlank()) {
                       throw new ExceptionDangerOfValueSymbolInStringName(name);
                    }
    }

}
