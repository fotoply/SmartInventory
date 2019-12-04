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
                        "1995",
                        "1994",
                        "2007",
                        "1977",
                        "2002",
                        "2001",
                        "2008",
                        "2011",
                        "2018",
                        "2017",
                        "1995",
                        "1994",
                        "2007",
                        "1977",
                        "2002",
                        "2001",
                        "2008",
                        "2011",
                        "2018",
                        "2017",
                        "1995",
                        "1994",
                        "2007",
                        "1977",
                        "2002",
                        "2001",
                        "2008",
                        "2011",
                        "2018",
                        "2017",
                        "1995",
                        "1994",
                        "2007",
                        "1977",
                        "2002",
                        "2001",
                        "2008",
                        "2011",
                        "2018",
                        "2017"
                };

        List<Ingredient> data = new ArrayList<>();
        for (int i = 0; i < 40; i++)
        {
            data.add(new Ingredient(new Product(names[i]), Double.valueOf(years[i])));
        }

        return data;
    }
}
