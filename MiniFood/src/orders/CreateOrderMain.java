package orders;

import products.Product;
import products.ProductService;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class CreateOrderMain {

    public static void main(String[] args)  throws IOException {
        OrderService orderService = new OrderService();
        UUID restaurantId = UUID.fromString("5ee66fc3-4012-4102-b397-38af9732a725");
        ProductService productService = new ProductService();

        Product product1 = productService.create
                (new Product("batata frita", "batata tamanho familia", 49),
        restaurantId);

        Product product2 = productService.create
                (new Product("batata frita", "batata tamanho familia", 49),
                        restaurantId);


       // UUID produtcID = product.getId();
        String customer = "Ranieri";

        Order order = orderService.create(restaurantId, Arrays.asList(product1.getId(), product2.getId()), customer);
        System.out.println(order);
    }
}
