package products;

import restaurant.Restaurant;

import java.util.UUID;

public class Product {

        private UUID id;
        private String  name;
        private String description;
        private double price;
        private Restaurant restaurant;


    public Product(String name, String description, double price ) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                '}';
    }
}
