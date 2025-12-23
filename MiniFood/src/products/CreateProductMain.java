package products;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.UUID;

public class CreateProductMain {

     private final static String PADARIA_RITA_ID= "5ee66fc3-4012-4102-b397-38af9732a725";
     private final static String BAR_DO_JOAO= "1aef9682-a7c2-4f94-bf09-0d6b143d99ca";

    public static void main(String[] args) throws IOException {
        ProductService productService = new ProductService();
        Product product = new Product(
                "batata frita",
                "bata Frita tamanho G",
                30
        );

        try {
             productService.create(
                    product, UUID.fromString(PADARIA_RITA_ID)
            );
             productService.create(
                   new  Product(
                         "temaki",
                         "temaki Skin completo",
                         37
                   ), UUID.fromString(PADARIA_RITA_ID)
            );
            productService.create(
                    new  Product(
                            "Coxinha",
                            "Coxinha de frango na promocao",
                            6
                    ), UUID.fromString(BAR_DO_JOAO)
            );
            List<Product> productList = productService.findAllByRestaurantId(UUID.fromString(PADARIA_RITA_ID));

            productList.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Deu erro no arquivo: "+ e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao cadrastrar: " + e.getMessage());
        }

    }
}
