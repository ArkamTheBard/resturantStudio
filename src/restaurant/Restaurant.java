package restaurant;

import java.util.ArrayList;

public class Restaurant {
    public static void main(String args[]){
        MenuItem item1 = new MenuItem("Burger", 4.25,
            "Big borgar", "main course", false);

        MenuItem item2 = new MenuItem("Garlic bread", 3.15,
            "small basket of sliced garlic bread", "appetizer");

        ArrayList<MenuItem> menu = new ArrayList<>();

        menu.add(item1);
        menu.add(item2);

        Menu restaurantMenu = new Menu(menu);

        System.out.println(restaurantMenu.toString());

        System.out.println(restaurantMenu.toString("Garlic bread"));
        System.out.println('\n');

        MenuItem item3 = new MenuItem("Ice cream", 1.00, "scoop of ice cream",
                "dessert", false);

        restaurantMenu.addItem(item3);

        System.out.println(restaurantMenu.toString());

        restaurantMenu.removeItem("Ice cream");

        System.out.println(restaurantMenu.toString());

        MenuItem item4 = new MenuItem("Burger", 4.25,
                "Big borgar", "main course", false);

        restaurantMenu.addItem(item4); //attempt to add similar item

        System.out.println('\n'+ restaurantMenu.toString()); //show item was not added
    }
}
