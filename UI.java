package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class UI extends JFrame {
    private ShoppingList shoppingList;

    UI() {
        shoppingList = new ShoppingList();
        this.getContentPane().add(this.prepareMainPanel());
        this.setFrame();
    }

    private JPanel prepareMainPanel() {
        // TODO Showing sum of paid money
        // TODO Showing how many product you still need to buy
        // TODO To buy dialog
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(600, 600));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(prepareSaveLoadPanel(), BorderLayout.LINE_END);
        mainPanel.add(prepareButtonPanel(), BorderLayout.PAGE_END);
        mainPanel.add(prepareShoppingListPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel prepareShoppingListPanel() {
        // TODO ScrollPane
        JPanel shoppingListPanel = new JPanel();
        shoppingListPanel.setLayout(new BorderLayout());
        shoppingListPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        shoppingListPanel.add(shoppingList);
        return shoppingListPanel;
    }

    private JPanel prepareSaveLoadPanel() {
        JPanel saveLoadPanel = new JPanel();
        saveLoadPanel.setLayout(new BoxLayout(saveLoadPanel, BoxLayout.Y_AXIS));
        saveLoadPanel.add(Box.createVerticalStrut(10));
        saveLoadPanel.add(prepareSaveButton());
        saveLoadPanel.add(Box.createVerticalStrut(10));
        saveLoadPanel.add(prepareLoadButton());
        return saveLoadPanel;
    }

    private JPanel prepareButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prepareAddButton());
        buttonPanel.add(prepareBuyButton());
        buttonPanel.add(prepareDeleteButton());
        buttonPanel.add(prepareClearButton());
        return buttonPanel;
    }

    private JButton prepareAddButton() {
        JButton tmpButton = new JButton("Add button");
        tmpButton.addActionListener((ActionEvent e) -> {
            String productName = DialogLibrary.showProductInputDialog();
            try {
                if (!productName.isEmpty()) {
                    shoppingList.addElement(productName);
                    return;
                }
                DialogLibrary.showEmptyInputDialog();
            } catch (NullPointerException ne) {
            }
        });
        return tmpButton;
    }

    private JButton prepareClearButton() {
        JButton tmpButton = new JButton("Clear button");
        tmpButton.addActionListener((ActionEvent e) -> shoppingList.clearList());
        return tmpButton;
    }

    private JButton prepareDeleteButton() {
        JButton tmpButton = new JButton("Delete button");
        tmpButton.addActionListener((ActionEvent e) -> {
            if (shoppingList.isNotSelected()) {
                DialogLibrary.showNotSelectedDialog();
                return;
            }
            shoppingList.deleteSelectedElement();
        });
        return tmpButton;
    }

    private JButton prepareBuyButton() {
        JButton tmpButton = new JButton("Buy button");
        tmpButton.addActionListener((ActionEvent e) -> {
            if (shoppingList.isNotSelected()) {
                DialogLibrary.showNotSelectedDialog();
                return;
            }
            String response = DialogLibrary.showPriceInputDialog();
            try {
                if (!response.isEmpty()) {
                    shoppingList.buySelectedElement(Float.parseFloat(response));
                    return;
                }
                DialogLibrary.showEmptyInputDialog();
            } catch (NullPointerException ne) {
            }
        });
        return tmpButton;
    }

    private JButton prepareSaveButton() {
        JButton tmpButton = new JButton("Save button");
        tmpButton.addActionListener((ActionEvent e) -> shoppingList.saveListToFile());
        return tmpButton;
    }

    private JButton prepareLoadButton() {
        JButton tmpButton = new JButton("Load button");
        tmpButton.addActionListener((ActionEvent e) -> shoppingList.loadListFromFile());
        return tmpButton;
    }

    private void setFrame() {
        this.setTitle("Shopping List");
        this.pack();
        this.setVisible(true);
    }


}
