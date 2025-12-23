package restaurant;

import java.util.UUID;

public class Restaurant {

  public static Object res;
  private UUID id;
  private String email;
  private String name;
  private String typeFood;

  public Restaurant() {
    this.id = UUID.randomUUID();
  }

  public Restaurant(String email, String name, String typeFood) {
    this.id = UUID.randomUUID();
    this.email = email;
    this.name = name;
    this.typeFood = typeFood;
  }

  // Getters and Setters
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

  public String getTypeFood() {
    return typeFood;
  }

  public void setTypeFood(String typeFood) {
    this.typeFood = typeFood;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", typeFood='" + typeFood + '\'' +
                '}';
    }
}
