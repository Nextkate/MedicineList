package com;

import javax.swing.*;

public class DialogLibrary {
    public static void showNotSelectedDialog() {
        JOptionPane.showMessageDialog(null,
                "You have not selected anything!",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void showEmptyInputDialog() {
        JOptionPane.showMessageDialog(null,
                "Your input was empty!",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    public static String showPriceInputDialog() {
        return JOptionPane.showInputDialog(null, "What is the price of product?");
    }

    public static String showProductInputDialog() {
        return JOptionPane.showInputDialog(null, "What product you want to add?");
    }


}
