package model;

import java.util.Arrays;

public enum TypeToy {
    FEMALE(0),
    MALE(1),

    UNICEX(2);

    private final int identifier;

    TypeToy(int identifier) {
        this.identifier = identifier;
    }

    // Static method to get the toy type from its identifier
    public static TypeToy getTypeByValue(int identifier) {
        // Search among all enum constants
        return Arrays.stream(TypeToy.values())
                // Filter the constants whose identifier matches the given value
                .filter(e -> e.identifier == identifier)
                // Return the first constant that meets the filter, or UNICEX if none is found
                .findFirst()
                .orElse(TypeToy.UNICEX);
    }
}
