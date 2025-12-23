package orders;

import products.Product;
import products.ProductService;
import restaurant.Restaurant;
import restaurant.RestaurantService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {


        ProductService productService = new ProductService();
        RestaurantService restaurantService = new RestaurantService();
        List<Order> orders = new ArrayList<>();

        public static Order create(UUID restaurantId, List<UUID> productIds, String customer) throws IOException {
            List<Product> products = productIds.stream()
                    .map( product -> this.productService.findById(product))
                    .toList();

            Restaurant restaurant = this.restaurantService.findById(restaurantId);

        Order order = new Order (restaurant, products, customer);
        order.setId(UUID.randomUUID());
        orders.add(order);
        return order;


        }
}
