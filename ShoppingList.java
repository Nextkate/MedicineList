package com;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class ShoppingList extends JList<ListEntry> {
    private Vector<ListEntry> list;

    ShoppingList() {
        super();
        this.list = new Vector<>();
        this.setFont(new Font("name", Font.ROMAN_BASELINE, 15));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addElement(String productName) {
        list.add(new ListEntry(productName));
        update();
    }

    public void clearList() {
        list.clear();
        update();
    }

    public void deleteSelectedElement() {
        list.remove(this.getSelectedIndex());
        update();
    }

    public void buySelectedElement(Float price) {
        // TODO Handle already bought error ??
        // TODO Handle wrong price error
        list.get(this.getSelectedIndex()).buyIt(price);
        update();
    }

    private void update() {
        this.setListData(list);
    }

    public boolean isNotSelected() {
        return this.getSelectedIndex() == -1;
    }

    public void saveListToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("list.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadListFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("list.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (Vector<ListEntry>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Error");
            c.printStackTrace();
        }
        update();
    }


}
