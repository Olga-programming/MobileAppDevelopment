package com.olga.day07customlistview;

public class Flower {
    private long productId;

    private String category;
    private String name;
    private String instructions;
    private Double price;
    private String photo;

    public Flower() {
    }

    public Flower(long productId, String category, String name, String instructions, Double price, String photo) {
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.instructions = instructions;
        this.price = price;
        this.photo = photo;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }
}
