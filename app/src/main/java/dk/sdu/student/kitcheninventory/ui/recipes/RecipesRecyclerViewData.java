package dk.sdu.student.kitcheninventory.ui.recipes;

import java.util.ArrayList;
import java.util.List;

import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.RecipeObject;

public class RecipesRecyclerViewData
{
    public static List<RecipeObject> GetData()
    {
        String[] names =
                {
                        "Pie",
                        "Cake",
                        "Brownies",
                        "Smoothie",
                        "Salad",
                        "Spaghetti Bolognese",
                        "Chili Con Carne",
                        "Oatmeal",
                        "Pizza",
                        "Lasagne",
                        "Pie",
                        "Cake",
                        "Brownies",
                        "Smoothie",
                        "Salad",
                        "Spaghetti Bolognese",
                        "Chili Con Carne",
                        "Oatmeal",
                        "Pizza",
                        "Lasagne",
                        "Pie",
                        "Cake",
                        "Brownies",
                        "Smoothie",
                        "Salad",
                        "Spaghetti Bolognese",
                        "Chili Con Carne",
                        "Oatmeal",
                        "Pizza",
                        "Lasagne",
                        "Pie",
                        "Cake",
                        "Brownies",
                        "Smoothie",
                        "Salad",
                        "Spaghetti Bolognese",
                        "Chili Con Carne",
                        "Oatmeal",
                        "Pizza",
                        "Lasagne"
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

        List<RecipeObject> data = new ArrayList<>();
        for (int i = 0; i < 40; i++)
        {
            data.add(new RecipeObject(new Product(names[i]), Double.valueOf(years[i])));
        }

        return data;
    }
}
