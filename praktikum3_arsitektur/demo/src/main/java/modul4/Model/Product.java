package modul4.Model;

public class Product {
    private int id;
    private  String name;
    private Double Price;

    public Product(int id, String name, Double Price){
        this.id = id;
        this.name = name;
        this.Price = Price;
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
    
    public Double getPrice() {
        return Price;
    }
    
    public void setPrice(Double price) {
        this.Price = price;
    }

}

