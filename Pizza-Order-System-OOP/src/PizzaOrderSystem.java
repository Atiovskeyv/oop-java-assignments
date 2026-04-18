// This program models a Pizza ordering system.
// It allows creating pizzas with size, crust type, and ingredients,
// validates selections, calculates price, and prints order summaries.

import java.util.ArrayList;
import java.util.Arrays;

class Pizza {

    private String size;
    private String crustType;
    private ArrayList<String> ingredients;
    private static int orderCount = 0;
    private final int id;

    static final ArrayList<String> sizeList =
            new ArrayList<>(Arrays.asList("Small", "Large"));

    static final ArrayList<String> crustTypeList =
            new ArrayList<>(Arrays.asList("Thin", "Thick"));

    static final ArrayList<String> ingredientList =
            new ArrayList<>(Arrays.asList("Mozzarella", "Sausage", "Olive", "Pepper", "Mushroom"));

    Pizza(String size, String crustType, ArrayList<String> ingredients) {
        this.size = "Small";
        this.crustType = "Thin";
        this.ingredients = new ArrayList<>();

        setSize(size);
        setCrustType(crustType);
        setIngredients(ingredients);

        orderCount++;
        id = orderCount;
    }

    Pizza(String size) {
        this.size = "Small";
        setSize(size);
        this.crustType = "Thin";
        this.ingredients = new ArrayList<>();
        orderCount++;
        id = orderCount;
    }

    void setSize(String size) {
        if (sizeList.contains(size)) {
            this.size = size;
        } else {
            IO.println("Invalid selection.");
        }
    }

    public String getSize() {
        return this.size;
    }

    void setCrustType(String crustType) {
        if (crustTypeList.contains(crustType)) {
            this.crustType = crustType;
        } else {
            IO.println("Invalid selection.");
        }
    }

    public String getCrustType() {
        return this.crustType;
    }

    void setIngredients(ArrayList<String> ingredients) {

        if (ingredients.size() > 3) {
            IO.println("You cannot select more than three ingredients.");
            return;
        }

        for (String ingredient : ingredients) {
            if (!ingredientList.contains(ingredient)) {
                IO.println("Invalid ingredient entered.");
                return;
            }
        }

        ArrayList<String> tempList = new ArrayList<>();

        for (String temp : ingredients) {
            if (tempList.contains(temp)) {
                IO.println("Duplicate ingredient is not allowed.");
                return;
            } else {
                tempList.add(temp);
            }
        }

        this.ingredients = new ArrayList<>(ingredients);
    }

    public ArrayList<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }

    public void addIngredient(String ingredient) {

        if (!ingredientList.contains(ingredient)) {
            IO.println("ERROR: '" + ingredient + "' is not in the menu. Options: " + ingredientList);
            return;
        }

        if (ingredients.size() >= 3) {
            IO.println("ERROR: Maximum 3 ingredients allowed. Current: " + ingredients);
            return;
        }

        ingredients.add(ingredient);
    }

    public void removeIngredient(String ingredient) {

        if (!ingredients.contains(ingredient)) {
            IO.println("ERROR: '" + ingredient + "' is not in the list.");
            return;
        }

        ingredients.remove(ingredient);
    }

    public double calculatePrice() {
        double price = 0;

        if (this.size.equals("Small")) {
            price = 49.99;
        } else if (this.size.equals("Large")) {
            price = 89.99;
        }

        price += this.ingredients.size() * 5.0;
        return price;
    }

    @Override
    public String toString() {
        return String.format(
                "╔══════════════════════════════════════╗\n" +
                        "  Order #%d\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "  Size     : %s\n" +
                        "  Crust    : %s\n" +
                        "  Ingredients : %s\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "  TOTAL    : %.2f TL\n" +
                        "╚══════════════════════════════════════╝\n",
                this.id,
                this.size,
                this.crustType,
                this.ingredients,
                calculatePrice()
        );
    }

    public String toString(boolean shortSummary) {
        if (shortSummary) {
            return String.format("[#%d] %s | %.2f TL\n", this.id, this.size, calculatePrice());
        } else {
            return this.toString();
        }
    }
}

void main() {

    IO.println("Size Options: " + Pizza.sizeList);
    IO.println("Crust Options: " + Pizza.crustTypeList);
    IO.println("Ingredient Options: " + Pizza.ingredientList);
    IO.println();
    IO.println("Maximum number of ingredients is 3.");

    ArrayList<Pizza> pizzas = new ArrayList<>();

    Pizza p1 = new Pizza("Large", "Thick",
            new ArrayList<>(Arrays.asList("Mozzarella", "Sausage")));

    pizzas.add(p1);
    IO.println(p1.toString());
    IO.println(p1.toString(true));

    Pizza p2 = new Pizza("Small");
    pizzas.add(p2);
    IO.println(p2.toString());

    p2.addIngredient("Sausage");
    p2.addIngredient("Olive");
    p2.addIngredient("Mushroom");
    p2.addIngredient("Pepper"); // ignored due to limit

    p2.removeIngredient("Olive");
    IO.println(p2.toString());

    p2.addIngredient("Olive");
    p2.removeIngredient("Cheese"); // error

    IO.println(p2.toString());

    Pizza p3 = new Pizza("");
    IO.println(p3.toString());

    p3.addIngredient("Pepperoni"); // invalid ingredient

    p3.setSize("Medium");
    p3.setCrustType("Medium");
    p3.setIngredients(new ArrayList<>(Arrays.asList("Corn", "Sausage")));

    for (Pizza p : pizzas) {
        IO.println(p.toString());
    }

    IO.println("Total orders: " + Pizza.orderCount);
}