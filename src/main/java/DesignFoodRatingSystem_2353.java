import java.util.HashMap;
import java.util.Map;

public class DesignFoodRatingSystem_2353 {

  public static void main(String[] args) {}

  class FoodRatings {

    private Map<String, String> hightRatedMap = new HashMap<>();

    private Map<String, Integer> foodIndexMap = new HashMap<>();
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

      this.foods = foods;
      this.cuisines = cuisines;
      this.ratings = ratings;

      for (int i = 0; i < cuisines.length; i++) {
        foodIndexMap.put(foods[i], i);
        String food = hightRatedMap.get(cuisines[i]);
        if (food != null) {
          if (ratings[foodIndexMap.get(food)] < ratings[i] && food.compareTo(foods[i]) > 0) {
            hightRatedMap.put(cuisines[i], foods[i]);
          }
        } else {
          hightRatedMap.put(cuisines[i], foods[i]);
        }
      }
    }

    public void changeRating(String food, int newRating) {
      Integer index = foodIndexMap.get(food);
      ratings[index] = newRating;
      String cuisine = cuisines[index];
      int rating = ratings[foodIndexMap.get(hightRatedMap.get(cuisine))];
    }

    public String highestRated(String cuisine) {
      return hightRatedMap.get(cuisine);
   }
  }
}
