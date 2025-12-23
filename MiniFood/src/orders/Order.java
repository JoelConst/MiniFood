package orders;

import products.Product;
import restaurant.Restaurant;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Restaurant restaurant;
    private List<Product> products;
    private String customer;

    public Order(Restaurant restaurant, List<Product> products, String customer) {
        this.restaurant = restaurant;
        this.products = products;
        this.customer= customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", products=" + products +
                ", customer='" + customer + '\'' +
                '}';
    }
}


