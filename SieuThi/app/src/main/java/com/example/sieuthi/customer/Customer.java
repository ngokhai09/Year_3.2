package com.example.sieuthi.customer;

import com.example.sieuthi.product.Product;

import java.util.List;

public class Customer {

    private String username;
    private List<Product> listProductInCart;

    public Customer(String username, List<Product> listProductInCart) {
        this.username = username;
        this.listProductInCart = listProductInCart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getListProductInCart() {
        return listProductInCart;
    }

    public void setListProductInCart(List<Product> listProductInCart) {
        this.listProductInCart = listProductInCart;
    }
}
