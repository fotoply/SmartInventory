package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdditionalTemplates {
    private static List<ProductTemplate> templates = new ArrayList<>();

    public static void load(List<ProductTemplate> templates) {
        AdditionalTemplates.templates.addAll(templates);
    }

    public static List<ProductTemplate> search(final String searchString) {
        return search(searchString, 10);
    }

    public static List<ProductTemplate> search(final String searchString, int limit) {
        return templates.stream()
                .filter(template -> template.getName().toLowerCase().contains(searchString.toLowerCase()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static ProductTemplate getByBarcode(String barcode) {
        Optional<ProductTemplate> barcodeResult = templates.stream()
                .filter(template -> template.getBarcode().equals(barcode))
                .findFirst();
        return barcodeResult.orElse(null);
    }
}
