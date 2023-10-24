package com.javamedical.medicalapp.services;

public class ReceiptItem {
    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double total;

    public void setDescription(String description) {
        this.description = description;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }


    public void setTotal(Double total) {
        this.total = total;
    }
}
