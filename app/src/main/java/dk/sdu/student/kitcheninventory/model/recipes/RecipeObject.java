package dk.sdu.student.kitcheninventory.model.recipes;

import dk.sdu.student.kitcheninventory.model.inventory.Product;

public class RecipeObject {
    private Product product;
    private double amount;

    public RecipeObject(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }
}
