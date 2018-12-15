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

    //private JPanel prepareButtonPanel() {
       //JPanel buttonPanel = new JPanel();
       // buttonPanel.add(prepareTakenButton());
       // buttonPanel.add(prepareNotTakenButton());
        //return buttonPanel;
    //}

    //public static void showTakenInputDialog() {
       // JOptionPane.showMessageDialog(null,
            //    "Are you sure?",
            //    "Warning",
            //    JOptionPane.WARNING_MESSAGE);
    }

    public static String showTimeInputDialog() {
        return JOptionPane.showInputDialog(null, "At what time have you take your medicine?");
    }

    public static String showProductInputDialog() {
        return JOptionPane.showInputDialog(null, "What medicine you want to add?");
    }

    public static String showTakenInputDialog(){
        return JOptionPane.showInputDialog(  null, "Taken or not?")

    }

// TO DO żeby były przyciski w środku tego a nie że wprowadzamy tekst
