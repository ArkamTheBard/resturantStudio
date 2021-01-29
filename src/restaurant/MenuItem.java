package restaurant;

import java.util.ArrayList;
import java.util.Locale;

public class MenuItem {
    private String name;
    private double price;
    private String description;
    private String category;
    private boolean isNew;

    private static final ArrayList<String> CATEGORIES = new ArrayList<>(){
        {
            add("appetizer");
            add("main course");
            add("dessert");
        }
    };


    public MenuItem(String name, double price, String description, String category, Boolean isNew){
        if(name.isEmpty()|| name == null || price < 0 || description == null || description.isEmpty() || category == null
                || category.isEmpty() || !CATEGORIES.contains(category.toLowerCase()) || isNew == null){ //Boolean can be null but not boolean
            throw new IllegalArgumentException("Illegal argument(s)");
        }else{
            this.name = name;
            setPrice(price);
            this.description = description;
            this.category = category;
            this.isNew = isNew;
        }
    }

    public MenuItem(String name, double price, String description, String category){
        if(name.isEmpty() || name == null|| price < 0 || description == null || description.isEmpty() || category == null
                || category.isEmpty() || !CATEGORIES.contains(category.toLowerCase())){ //Boolean can be null but not boolean
            throw new IllegalArgumentException("Illegal argument(s)");
        }else{
            this.name = name;
            setPrice(price);
            this.description = description;
            this.category = category;
            this.isNew = true;
        }
    }

    public MenuItem(MenuItem item) {
        setPrice(price);
        this.description = description;
        this.category = category;
        this.isNew = isNew;
    }

    public String toString(){
        if(this.isNew) {
            return this.name + " $" + this.price + " " + this.description + " " + this.category + " NEW!!";
        }else{
            return this.name + " $" + this.price + " " + this.description + " " + this.category;
        }
    }

    public boolean equals(Object toBeCompared){
        if(toBeCompared == this) {return true;}

        if(toBeCompared == null) {return false;}

        if(toBeCompared.getClass() != getClass()) {return false;}

        MenuItem theItem = (MenuItem) toBeCompared;
        return theItem.name == this.name && theItem.price == this.price && theItem.description.equals(this.description)
                && theItem.category.equals(this.category) && theItem.isNew == this.isNew;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }else
            this.price = price;
    }

    public void changeNew(){
        if(!this.isNew){
            throw new IllegalStateException("Item is already not new");
        }else{
            this.isNew = false;
        }
    }

    public void changeDescription(String newDescription){
        if(newDescription == null || newDescription.isEmpty()){
            throw new IllegalArgumentException("Description cannot be null or empty");
        }else{
            this.description = newDescription;
        }
    }

    public void changeCategory(String newCat){
        if(!CATEGORIES.contains(newCat)){
            throw new IllegalArgumentException("Not a valid category");
        }else{
            this.category = newCat;
        }
    }

    public String getName(){
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getIsNew(){
        return this.isNew;
    }
}
