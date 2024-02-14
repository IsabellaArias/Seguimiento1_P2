package model;

import java.io.Serializable;

public class Toy implements Serializable {
    private String name;
    private TypeToy type;
    private Integer price;
    private Integer amount;

    public Toy() {
    }

    public Toy(String name, TypeToy type, Integer price, Integer amount) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public TypeToy getType() {return type;}

    public void setType(TypeToy type) {this.type = type;}

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {this.price = price;}

    public Integer getAmount() {return amount;}

    public void setAmount(Integer amount) {this.amount = amount;}
}
