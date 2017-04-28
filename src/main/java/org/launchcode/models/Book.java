package org.launchcode.models;


/**
 * Created by LaunchCode
 */
public class Book {

    private int id;
    private static int nextId = 1;

    private String buyer_name;
    private Long isbn;
    private int quantity;
    private double price;
    private double amazon_price;


    public Book() {
        id = nextId;
        nextId++;
    }

    public Book(String aBuyer, Long aIsbn, double aPrice) {

        this();

        buyer_name = aBuyer;
        isbn = aIsbn;
        price = aPrice;

    }

    public Book(String aBuyer, Long aIsbn, int aQuantity, double aPrice) {

        this();

        buyer_name = aBuyer;
        isbn = aIsbn;
        quantity = aQuantity;
        price = aPrice;

    }

    public Book(String aBuyer, Long aIsbn, int aQuantity, double aPrice, double aAmazon_price) {

        this();

        buyer_name = aBuyer;
        isbn = aIsbn;
        quantity = aQuantity;
        price = aPrice;
        amazon_price = aAmazon_price;


    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public Long getISBN() {
        return isbn;
    }

    public void setISBN(Long isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDateCreated() {
        return amazon_price;
    }

    public void setDateCreated(double dateCreated) {
        this.amazon_price = dateCreated;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
