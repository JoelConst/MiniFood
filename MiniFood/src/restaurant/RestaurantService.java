package restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantService {

  private List<Restaurant> tableRestaurant = new ArrayList<>();

  public String create(Restaurant restaurant) throws Exception {

    // salvar o restaurante
    // nao deve ser possivel cadrastar mais de um restaurente com o mesmo email;
    // nao deve ser possivel cadastrar restaurante sem email e nome;
    Optional<Restaurant> restaurantOptional = tableRestaurant.stream()
        .filter(res -> res.getEmail().equals(restaurant.getEmail())).findFirst();

    if (restaurantOptional.isPresent()) {
      // return "E-mail ja cadastrado, Nao permitir o cadastro";
      throw new Exception("E-mail ja cadastrado, Nao permitir o cadastro");
    }
    if (restaurant.getEmail() == null || restaurant.getName() == null) {
      throw new Exception("E-mail e nome sao obrigatorios");

    }

    tableRestaurant.add(restaurant);
    System.out.println(restaurant.getId());

    RestaurantUtils.saveRestaurant(restaurant);

    return "Restaurante cadastrado com sucesso!";

  }

  public List<Restaurant> getAll() throws IOException {
      tableRestaurant.clear();
      try (BufferedReader br = new BufferedReader( new FileReader("tblRestaurantes"))) {
          String line;


          while((line = br.readLine()) != null) {
              String[] data = line.split(";");
              if(data.length == 4) {
                  UUID id = UUID.fromString(data[0]);
                  String email = data[1];
                  String name = data[2];
                  String typeFood = data[3];

                  Restaurant restaurant = new Restaurant();
                  restaurant.setId(id);
                  restaurant.setEmail(email);
                  restaurant.setName(name);
                  restaurant.setTypeFood(typeFood);
                  tableRestaurant.add(restaurant);
              }
          }
      }
      return tableRestaurant;
  }

  public Restaurant findById(UUID id) throws IOException {
      List<Restaurant> restaurants = getAll();
      return restaurants.stream().filter(  res -> res.getId().equals(id))
              .findFirst()
              .orElseThrow(() -> {
                  throw  new IllegalArgumentException("Restaurante nao encontrado");
              });
  }
}