
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ndwat
 */
public class StorageFacility {

    private final String unit;
    private final String item;
    private final HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.unit = "";
        this.item = "";
        this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storage
                .computeIfAbsent(unit, k -> new ArrayList<String>()).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (this.storage.containsKey(storageUnit)) {
            return this.storage.get(storageUnit);
        }

        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {
        this.storage.computeIfPresent(storageUnit, (key, value) -> {
            value.remove(item);
            return value.isEmpty() ? null : value;
        });
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();

        for (String key : this.storage.keySet()) {
            units.add(key);
        }

        return units;
    }
}
