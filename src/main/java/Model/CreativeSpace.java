/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ricardo
 */
public class CreativeSpace {
    private int id;
    private String name;
    private String Type;
    private int capacity;
    private int price;
    private String location;
    public static final String[] LABEL_CREATIVESPACES = {"ID","NAME","TYPE","CAPACITY","PRICE","LOCATION",};

    public CreativeSpace() {
    }

    

    public CreativeSpace(int id, String name, String Type, int capacity, int price, String location) {
        this.id = id;
        this.name = name;
        this.Type = Type;
        this.capacity = capacity;
        this.price = price;
        this.location = location;
    }
    
    public String setColumData(int colum){
        switch (colum) {
            case 0:
                return String.valueOf(this.getId());
                
            case 1:
                return this.getName();
                
            case 2:
                return this.getType();
                
            case 3:
                return String.valueOf(this.getCapacity());
                
            case 4:
                return String.valueOf(this.getPrice());
                
            case 5: 
                return this.getLocation();
                

        }
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CreativeSpace " + "id=" + id + ", name=" + name + ", Type=" + Type + ", capacity=" + capacity + ", price=" + price + ", location=" + location;
    }

    
    
    
}
