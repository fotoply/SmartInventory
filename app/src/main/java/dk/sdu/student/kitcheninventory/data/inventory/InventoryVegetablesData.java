package dk.sdu.student.kitcheninventory.data.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dk.sdu.student.kitcheninventory.model.inventory.Inventory;
import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.Ingredient;

public class InventoryVegetablesData
{
    public static List<Ingredient> GetData()
    {
        return Inventory.getInstance().getCompartmentByName("Grøntsager").getProducts().stream().map(product -> new Ingredient(product, product.getAmount())).collect(Collectors.toList());
    }
}
