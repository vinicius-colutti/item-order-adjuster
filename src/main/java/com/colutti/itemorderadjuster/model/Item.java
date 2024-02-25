package com.colutti.itemorderadjuster.model;

public class Item {

    private String name;
    private int order;

    public Item(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
