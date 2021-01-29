package restaurant;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private ArrayList<MenuItem> menu;
    private Date lastUpdated;

    public Menu(){ //empty menu
        this.menu = new ArrayList<>();
        this.lastUpdated = new Date();
    }

    public Menu(ArrayList<MenuItem>menuItems){
        if(menuItems.isEmpty()){
            throw new IllegalArgumentException("Must provide non-null/empty parameters");
        }else {
            this.menu = new ArrayList<>();
            for (MenuItem item : menuItems) { //deep copy to create Menu
                this.menu.add(item);
            }
            this.lastUpdated = new Date();
        }
    }
    public Menu(ArrayList<MenuItem>menuItems, Date date){
        if(menuItems.isEmpty() || date == null){
            throw new IllegalArgumentException("Must provide non-null/empty parameters");
        }else {
            this.menu = new ArrayList<>();
            for (MenuItem item : menuItems) { //deep copy to create Menu
                this.menu.add(item);
            }
            this.lastUpdated = date;
        }
    }

    public void setItems(ArrayList<MenuItem> menuItems){
        if(menuItems.isEmpty()){
            throw new IllegalArgumentException("Must provide non-null/empty parameters");
        }else {
            for (MenuItem item : menuItems) { //deep copy to create Menu
                this.menu.add(new MenuItem(item));
            }
            this.lastUpdated = new Date();
        }
    }

    public String toString(){
        String str = "~Casa de Yard menu~ **************\n";
        for(MenuItem item : this.menu){
            str += item.toString() + '\n';
        }
        str += "Menu was last updated on: " + lastUpdated.toString();
        return str;
    }

    public String toString(String itemName){
        String str = "";
        if(itemName == null || itemName.isEmpty()){
            throw new IllegalArgumentException("Must provide item name");
        }else{
            for(MenuItem item: this.menu){
                if(item.getName().equals(itemName)){
                    str = item.toString();
                }
            }
        }

        return str;
    }

    public void addItem(MenuItem item){
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }else if(this.menu.contains(item)){
            System.out.println("Item already exists within the menu");
        }else{
            this.menu.add(item);
            this.lastUpdated = new Date();
        }
    }

    public void removeItem(String itemName){
        ArrayList<MenuItem> menuToBe = new ArrayList<>();
        if(itemName == null || itemName.isEmpty()){
            throw new IllegalArgumentException("Must provide item name");
        }else{
            for(MenuItem item: this.menu){
                if(!item.getName().equals(itemName)){
                    menuToBe.add(item);
                }
            }
            this.menu = menuToBe;
        }
    }
}
