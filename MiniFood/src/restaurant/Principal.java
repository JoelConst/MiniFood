package restaurant;

import java.io.IOException;
import java.util.List;

public class Principal {

  public static void main(String[] args) throws IOException {
       getRestaurant();
  }

  static void aula2() throws Exception {

      Restaurant restaurant = new Restaurant();
      RestaurantService restaurantService = new RestaurantService();

      // restaurant.setEmail("bardojoao@gmail.com");
      // restaurant.setName(" Bar do Joao");
      // restaurant.setTypeFood("Brasileira");

      // try {
      // String message1 = restaurantService.create(restaurant);
      // System.out.println(message1);

      // catch (Exception e) {
      // System.out.println("Deu ruim... " + e.getMessage());

      Restaurant restaurantFile = RestaurantUtils.convertFileToRestaurant("restaurante");
      String message = restaurantService.create(restaurantFile);
      System.out.println(message);
  }

    static void getRestaurant() throws IOException {
      RestaurantService restaurantService = new RestaurantService();
      List<Restaurant> restaurants = restaurantService.getAll();

   //     for(Restaurant resTemp : restaurants) {
          //  System.out.println(resTemp);

        restaurants.forEach(System.out::println);
    }

}
