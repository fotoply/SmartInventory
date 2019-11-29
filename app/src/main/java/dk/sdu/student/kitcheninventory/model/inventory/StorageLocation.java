package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;

public class StorageLocation {

    private String name;
    private List<StorageCompartment> storageCompartments;

    public StorageLocation(String name) {
        this.name = name;
        storageCompartments = new ArrayList<>();
    }
}
