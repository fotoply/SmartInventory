package dk.sdu.student.kitcheninventory.data.shopping;

import java.util.ArrayList;
import java.util.List;

import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.Ingredient;

public class ShoppingGroceryListData
{
    public static List<Ingredient> GetData()
    {
        String[] names =
                {
                        "Banana",
                        "Apple",
                        "Watermelon",
                        "Salmon",
                        "Beef",
                        "Chicken",
                        "Tuna",
                        "Carrots",
                        "Spinach",
                        "Cashews",
                        "Banana",
                        "Apple",
                        "Watermelon",
                        "Salmon",
                        "Beef",
                        "Chicken",
                        "Tuna",
                        "Carrots",
                        "Spinach",
                        "Cashews",
                        "Banana",
                        "Apple",
                        "Watermelon",
                        "Salmon",
                        "Beef",
                        "Chicken",
                        "Tuna",
                        "Carrots",
                        "Spinach",
                        "Cashews",
                        "Banana",
                        "Apple",
                        "Watermelon",
                        "Salmon",
                        "Beef",
                        "Chicken",
                        "Tuna",
                        "Carrots",
                        "Spinach",
                        "Cashews"
                };

        String[] years =
                {
                        "10",
                        "2",
                        "5",
                        "15",
                        "7",
                        "1",
                        "3",
                        "20",
                        "9",
                        "2",
                        "10",
                        "2",
                        "5",
                        "15",
                        "7",
                        "1",
                        "3",
                        "20",
                        "9",
                        "2",
                        "10",
                        "2",
                        "5",
                        "15",
                        "7",
                        "1",
                        "3",
                        "20",
                        "9",
                        "2",
                        "10",
                        "2",
                        "5",
                        "15",
                        "7",
                        "1",
                        "3",
                        "20",
                        "9",
                        "2"
                };

        List<Ingredient> data = new ArrayList<>();
        for (int i = 0; i < 40; i++)
        {
            data.add(new Ingredient(new Product(names[i]), Double.valueOf(years[i])));
        }

        return data;
    }
}
