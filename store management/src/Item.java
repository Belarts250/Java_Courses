import java.util.ArrayList;

public class Item {
    private int id;
    private  String name;
    private double quantity;

    Item(int id, String name, double quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    void setId(int id){
        this.id = id;
    }

    public int getId(){
        return  id ;
    }

    void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    void setQuantity(double quantity){
        this.quantity = quantity;
    }

    public  double getQuantity(){
        return  quantity;
    }


    public void updateQuantity(double quantity){
        this.quantity += quantity;
    }

}

abstract  class Store{
    protected ArrayList<Item> inventory = new ArrayList<>();

    public Store( ){
         this.inventory = new ArrayList<>();
    }

    public abstract void addItem (Item item, double quantity);
    public abstract  void removeItem(int itemId, double quantity);


    public void displayInventory(){
        for(Item item : inventory){
            System.out.println("ID"+ item.getId()+ "|" + item.getName() + "|" + item.getQuantity());
        }
    }
}

class StoreManager extends Store{
    @Override
    public void addItem(Item item, double quantity){
        for(Item exists: inventory){
            if(exists.getId() == item.getId() ){
                exists.updateQuantity(quantity);
                return;
            }
        }
        inventory.add(item);
    }
    @Override
    public void removeItem(int itemId, double quantity){
        for(Item item: inventory){
            if (item.getQuantity() >= quantity) {
                item.updateQuantity(-quantity);  // Subtract quantity if sufficient stock
                System.out.println("Removed " + quantity + " of " + item.getName());
            } else {
                System.out.println("Insufficient stock for item: " + item.getName());
            }

        }
    }

}

class Program {
    public static void main(String[] args) {
        // Create store manager object
        StoreManager storeManager = new StoreManager();

        // Create some items
        Item item1 = new Item(1, "Laptop", 10);
        Item item2 = new Item(2, "Smartphone", 20);
        Item item3 = new Item(3, "Headphones", 15);

        // Add items to inventory
        storeManager.addItem(item1, 10);
        storeManager.addItem(item2, 20);
        storeManager.addItem(item3, 15);

        // Display current inventory
        storeManager.displayInventory();

        // Remove items from inventory
        storeManager.removeItem(1, 5);  // Remove 5 laptops
        storeManager.removeItem(2, 30); // Try to remove 30 smartphones (insufficient stock)
        storeManager.removeItem(4, 10); // Try to remove an item not in stock

        // Display updated inventory
        storeManager.displayInventory();
    }
}