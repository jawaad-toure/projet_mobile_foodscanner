package com.univ_amu.food_scanner.data.network;

import java.util.List;

public class NetworkFood {
    String code;
    String name;
    String brands;
    String nutriscore;
    List<NetworkQuantity> quantities;

    public static class NetworkQuantity {
        String name;
        int rank;
        int level;
        double quantity;
        String unit;

        public NetworkQuantity(String name, int rank, int level, double quantity, String unit) {
            this.name = name;
            this.rank = rank;
            this.level = level;
            this.quantity = quantity;
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Rank: " + rank + ", Level: " + level + ", Quantity: " + quantity + " " + unit;
        }
    }

    public NetworkFood(String code, String name, String brands, String nutriscore, List<NetworkQuantity> quantities) {
        this.code = code;
        this.name = name;
        this.brands = brands;
        this.nutriscore = nutriscore;
        this.quantities = quantities;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code: ").append(code).append("\n");
        stringBuilder.append("Name: ").append(name).append("\n");
        stringBuilder.append("Brands: ").append(brands).append("\n");
        stringBuilder.append("Nutriscore: ").append(nutriscore).append("\n");
        stringBuilder.append("Quantities: \n");
        for (NetworkQuantity quantity : quantities) {
            stringBuilder.append("\t").append(quantity.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}