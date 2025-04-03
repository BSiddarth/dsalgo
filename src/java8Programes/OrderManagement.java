package java8Programes;

import java.util.*;
import java.util.stream.*;

class Order {
    int id;
    List<Item> items;

    Order(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    String name;
    String category;
    double price;

    Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, Arrays.asList(
                        new Item("Laptop", "Electronics", 1000.0),
                        new Item("Headphones", "Electronics", 100.0),
                        new Item("Apple", "Food", 2.0))),
                new Order(2, Arrays.asList(
                        new Item("Banana", "Food", 1.5),
                        new Item("TV", "Electronics", 600.0),
                        new Item("Carrot", "Food", 1.0))),
                new Order(3, Arrays.asList(
                        new Item("Phone", "Electronics", 700.0),
                        new Item("Orange", "Food", 1.2)))
        );

        Map<String, Double> averagePriceByCategory = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(
                        Item::getCategory,
                        Collectors.averagingDouble(Item::getPrice)
                ));

        averagePriceByCategory.forEach((category, avgPrice) ->
                System.out.println("Category: " + category + ", Average Price: " + avgPrice)
        );


    }


}

