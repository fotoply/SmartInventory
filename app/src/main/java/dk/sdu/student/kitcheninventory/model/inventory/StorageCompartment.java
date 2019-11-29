package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;

public class StorageCompartment {

    private String name;
    private List<Product> products;

    public StorageCompartment(String name) {
        this.name = name;
        products = new ArrayList<>();
    }
}
