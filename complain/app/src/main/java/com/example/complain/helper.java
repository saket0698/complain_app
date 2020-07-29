package com.example.complain;

public class helper {
    String name,address,imei,product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public helper() {
    }

    public helper(String name, String address, String imei, String product) {
        this.name = name;
        this.address = address;
        this.imei = imei;
        this.product = product;
    }
}
