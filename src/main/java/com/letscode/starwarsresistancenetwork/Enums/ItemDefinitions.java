package com.letscode.starwarsresistancenetwork.Enums;

public enum ItemDefinitions {
    WEAPON("4"),
    AMMUNITION("3"),
    WATER("2"),
    FOOD("1");

    String itemPoints;

    ItemDefinitions(String item) {
        this.itemPoints = item;
    }

    public int getItemPoints() {
        return Integer.parseInt(itemPoints);
    }
}
