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
                        "Bananer",
                        "Æbler",
                        "Vandmeloner",
                        "Laks",
                        "Hakkebøffer",
                        "Kyllinger",
                        "Tun",
                        "Gulerødder",
                        "Spinat",
                        "Cashewnødder",
                        "Bananer",
                        "Æbler",
                        "Vandmeloner",
                        "Laks",
                        "Hakkebøffer",
                        "Kyllinger",
                        "Tun",
                        "Gulerødder",
                        "Spinat",
                        "Cashewnødder",
                        "Bananer",
                        "Æbler",
                        "Vandmeloner",
                        "Laks",
                        "Hakkebøffer",
                        "Kyllinger",
                        "Tun",
                        "Gulerødder",
                        "Spinat",
                        "Cashewnødder",
                        "Bananer",
                        "Æbler",
                        "Vandmeloner",
                        "Laks",
                        "Hakkebøffer",
                        "Kyllinger",
                        "Tun",
                        "Gulerødder",
                        "Spinat",
                        "Cashewnødder"
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
