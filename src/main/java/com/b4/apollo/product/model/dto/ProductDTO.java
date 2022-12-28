package com.b4.apollo.product.model.dto;

public class ProductDTO {
    private int productNo;
    private String productName;
    private int ProductPrice;
    private String productDesc;
    private int productQTY;
    private String categoryCode;

    public ProductDTO() {
    }

    public ProductDTO(int productNo, String productName, int productPrice, String productDesc, int productQTY, String categoryCode) {
        this.productNo = productNo;
        this.productName = productName;
        ProductPrice = productPrice;
        this.productDesc = productDesc;
        this.productQTY = productQTY;
        this.categoryCode = categoryCode;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductQTY() {
        return productQTY;
    }

    public void setProductQTY(int productQTY) {
        this.productQTY = productQTY;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
