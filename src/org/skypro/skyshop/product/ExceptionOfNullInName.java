package org.skypro.skyshop.product;

public class ExceptionOfNullInName extends IllegalArgumentException{
    String name;
    public ExceptionOfNullInName() {
        super();
    }

    @Override
    public String toString() {

        return "Exc.ExceptionOfNullInName.toString" + ": недопустимое значение Null - " + name;

    }
  }
