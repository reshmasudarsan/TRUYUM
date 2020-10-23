package com.cognizant.truyum.model;

import java.util.*;

public class Cart {
    private List<MenuItem> menuItemList;
    private double total;

    public Cart(List<MenuItem> menuItemList, double total) {
        this.menuItemList = menuItemList;
        this.total = total;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (menuItemList == null) {
            if (other.menuItemList != null)
                return false;
        } else if (!menuItemList.equals(other.menuItemList))
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        return true;
    }

}
