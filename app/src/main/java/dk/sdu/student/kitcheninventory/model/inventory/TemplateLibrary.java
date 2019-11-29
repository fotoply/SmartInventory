package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.List;
import java.util.stream.Collectors;

public class TemplateLibrary {

    public static List<ProductTemplate> search(String searchString) {
        List<ProductTemplate> searchResult = AdditionalTemplates.search(searchString);
        searchResult.addAll(DefaultTemplates.search(searchString));
        return searchResult.stream().limit(10).collect(Collectors.toList());
    }
}
