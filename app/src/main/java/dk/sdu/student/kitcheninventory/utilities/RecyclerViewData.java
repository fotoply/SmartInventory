package dk.sdu.student.kitcheninventory.utilities;

import java.util.ArrayList;
import java.util.List;

import dk.sdu.student.kitcheninventory.model.inventory.Product;
import dk.sdu.student.kitcheninventory.model.recipes.RecipeObject;

public class RecyclerViewData
{
    public static List<RecipeObject> GetData()
    {
        String[] names =
                {
                        "Forrest Gump",
                        "Shawshank Redemption",
                        "The Dark Knight",
                        "Star Wars",
                        "Harry Potter",
                        "Lord of The Rings",
                        "Iron Man",
                        "Captain America",
                        "Black Panther",
                        "Spiderman",
                        "Forrest Gump",
                        "Shawshank Redemption",
                        "The Dark Knight",
                        "Star Wars",
                        "Harry Potter",
                        "Lord of The Rings",
                        "Iron Man",
                        "Captain America",
                        "Black Panther",
                        "Spiderman",
                        "Forrest Gump",
                        "Shawshank Redemption",
                        "The Dark Knight",
                        "Star Wars",
                        "Harry Potter",
                        "Lord of The Rings",
                        "Iron Man",
                        "Captain America",
                        "Black Panther",
                        "Spiderman",
                        "Forrest Gump",
                        "Shawshank Redemption",
                        "The Dark Knight",
                        "Star Wars",
                        "Harry Potter",
                        "Lord of The Rings",
                        "Iron Man",
                        "Captain America",
                        "Black Panther",
                        "Spiderman"
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
