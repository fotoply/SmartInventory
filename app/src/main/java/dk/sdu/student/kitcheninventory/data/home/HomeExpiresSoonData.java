package dk.sdu.student.kitcheninventory.data.home;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dk.sdu.student.kitcheninventory.model.inventory.Inventory;
import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.Ingredient;

public class HomeExpiresSoonData
{
    public static List<Ingredient> GetData()
    {
        List<Product> products = Inventory.getInstance().getProductsByExpirationDate();
        return products.stream().map(product -> new Ingredient(product, product.getAmount())).collect(Collectors.toList());
    }
}
