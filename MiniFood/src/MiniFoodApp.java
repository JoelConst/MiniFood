import orders.Order;
import orders.OrderService;
import products.Product;
import products.ProductService;
import restaurant.Restaurant;
import restaurant.RestaurantService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MiniFoodApp {

    private static Scanner scanner = new Scanner(System.in);
    private static RestaurantService restaurantService = new RestaurantService();
    private  static ProductService productService =  new ProductService();
    private  static OrderService orderService = new OrderService();


    public static void main(String[] args) throws Exception {

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextInt();

            switch(option) {
                case 1 ->createRestaurant();
                case 2 ->createProduct();
                case 3 ->listAllRestaurants();
                case 4 ->listAllProducts();
                case 5 ->createOrder();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida");
            }

        }while(option != 0);

    }

    private static void showMenu() {

        System.out.println("==== MiniFood Console ====");
        System.out.println("Digite a opcao desejada");
        System.out.println("1 - Cadrastar Restaurante");
        System.out.println("2 - Cadrastar Produto");
        System.out.println("3 - Listar Restaurante");
        System.out.println("4 - Listar Produtos");
        System.out.println("5 - Cadrastar Pedido");
        System.out.println("Ou digite 0 para sair");
    }

    private static void createRestaurant() throws Exception {
        System.out.println("==== Cadrastar Restaurante ====");
        System.out.println("Digite o nome do restaurante");
        String name = scanner.nextLine();
        System.out.println("Digite o e-mail do restaurante");
        String email = scanner.nextLine();
        System.out.println(" Digite o tipo de Comida");
        String typeFood = scanner.nextLine();

        Restaurant restaurant = new Restaurant(name, email, typeFood);
        restaurantService.create(restaurant);
    }

    private static void createProduct() throws IOException {
        System.out.println("==== Cadrastar Produto ====");
        System.out.println("Digite o nome do produto");
        String name = scanner.nextLine();
        System.out.println("digite o ID do restaurante");
        String id = scanner.nextLine();
        System.out.println("Digite a descricao do Produto");
        String description = scanner.nextLine();
        System.out.println(" Digite o preco");
        double price = scanner.nextDouble();


        Product product = new Product(name, description, price);
        productService.create(product, UUID.fromString(id));
    }

    private static void listAllRestaurants() throws IOException {
        System.out.println("==== Listando Restaurantes ====");
      restaurantService.getAll().forEach(System.out::println);
    }

    private static void listAllProducts(){
        System.out.println("==== Listando Produtos ====");
        System.out.println("Digite o ID do Restaurante");
        UUID id = UUID.fromString(scanner.nextLine());
        List<Product> products =  productService.findAllByRestaurantId(id);
        products.forEach(System.out::println);

    }

    private static void createOrder() throws IOException{
        System.out.println("==== Cadrastar Pedido ====");
        System.out.println(" Digite o nome do cliente");
        String customer = scanner.nextLine();
        System.out.println("Digite o id do Restaurante");
        String restaurantID = scanner.nextLine();
        System.out.println("Digite o id do Produto");
        String productID = scanner.nextLine();

         Order order = OrderService.create(UUID.fromString(restaurantID), Arrays.asList(UUID.fromString(productID)), customer);
        System.out.println(order);

    }


}

