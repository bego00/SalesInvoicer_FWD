/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appModel;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ahmed
 */
public class Header {

    private int num;
    private String name;
    private Date date;
    private ArrayList<Item> items;

    public Header(int num, String name, Date date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        if (items == null) {
            items = new ArrayList();
        }
        return items;
    }

    @Override
    public String toString() {
        return "Header{" + "num=" + num + ", name=" + name + ", date=" + date + ", items=" + items + '}';
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

}
