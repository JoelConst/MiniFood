package restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RestaurantUtils {

  public static Restaurant convertFileToRestaurant(String fileName) {

    String name = "";
    String email = "";
    String typeFood = "";

    try {

      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line;

      while ((line = br.readLine()) != null) {
        String[] keyValue = line.split(":", 2);
        String key = keyValue[0];
        String value = keyValue[1];

        if (key.equals("name")) {
          name = value;
        } else if (key.equals("email")) {
          email = value;
        } else if (key.equals("typeFood")) {
          typeFood = value;
        }

      }
      br.close();

    } catch (IOException e) {
      System.out.println("Deu Erro ao carregar arquivo: " + e.getMessage());

    }
    return new Restaurant(name, email, typeFood);
  }

  public static void saveRestaurant(Restaurant restaurant) throws IOException {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("tblRestaurantes", true))) {

      String infoRestaurant = restaurant.getId() + ";" + restaurant.getEmail() + "," + restaurant.getName() + ","
          + restaurant.getTypeFood();
      bw.newLine();
      bw.write(infoRestaurant);
      bw.close();
    }
  }
}
