package dk.sdu.student.kitcheninventory.ui.inventory;

import java.util.ArrayList;
import java.util.List;

import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.Ingredient;

public class InventoryRecyclerViewDataMeats
{
    public static List<Ingredient> GetData()
    {
        String[] names =
                {
                        "Chicken",
                        "Beef",
                        "Lamb",
                        "Turkey",
                        "Salmon",
                        "Sardines",
                        "Shrimps",
                        "Tuna",
                        "Roastbeef",
                        "Ham",
                        "Chicken",
                        "Beef",
                        "Lamb",
                        "Turkey",
                        "Salmon",
                        "Sardines",
                        "Shrimps",
                        "Tuna",
                        "Roastbeef",
                        "Ham",
                        "Chicken",
                        "Beef",
                        "Lamb",
                        "Turkey",
                        "Salmon",
                        "Sardines",
                        "Shrimps",
                        "Tuna",
                        "Roastbeef",
                        "Ham",
                        "Chicken",
                        "Beef",
                        "Lamb",
                        "Turkey",
                        "Salmon",
                        "Sardines",
                        "Shrimps",
                        "Tuna",
                        "Roastbeef",
                        "Ham"
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
