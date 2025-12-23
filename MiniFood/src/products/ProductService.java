package products;

import restaurant.Restaurant;
import restaurant.RestaurantService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class ProductService {
    
    RestaurantService restaurantService = new RestaurantService();
    private static List<Product> products = new ArrayList<>();
        public Product create(Product product, UUID restaurantId)  throws IOException {



        Restaurant restaurant = restaurantService.findById(restaurantId);

        product.setId(UUID.randomUUID());
        product.setRestaurant(restaurant);

        products.add(product);
        return product;

    }

    public List<Product> findAllByRestaurantId(UUID restaurantId) {
        return products.stream()
                .filter(product ->
                        product.getRestaurant().getId().equals(restaurantId))
                .toList();
    }

    public Product findById(UUID productId) {
        return products.stream()
                .filter(product ->
                        product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Produto nao encontrado4")
                });
    }
}
 