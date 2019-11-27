package dk.sdu.student.kitcheninventory.model;

import java.io.Serializable;

public class ProductTemplate implements Serializable {


    private String name;
    private Category category;
    private double expirationTime;
    private double amount;

    public ProductTemplate(String name, Category category, double expirationTime, double amount) {
        this.name = name;
        this.category = category;
        this.expirationTime = expirationTime;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getExpirationTime() {
        return expirationTime;
    }

    public double getAmount() {
        return amount;
    }
}
