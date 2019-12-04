package dk.sdu.student.kitcheninventory.model.inventory;

import java.io.Serializable;

public class ProductTemplate implements Serializable {


    private String name;
    private String category;
    private double expirationTime;
    private double amount;
    private String barcode;

    public String getBarcode() {
        return barcode;
    }

    public ProductTemplate(String name, String category, double expirationTime, double amount) {
        this(name, category, expirationTime, amount, "");
    }

    public ProductTemplate(String name, String category, double expirationTime, double amount, String barcode) {
        this.name = name;
        this.category = category;
        this.expirationTime = expirationTime;
        this.amount = amount;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getExpirationTime() {
        return expirationTime;
    }

    public double getAmount() {
        return amount;
    }
}
