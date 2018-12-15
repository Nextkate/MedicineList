package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class UI extends JFrame {
    private MedicineList medicineList;

    UI() {
        medicineList = new MedicineList();
        this.getContentPane().add(this.prepareMainPanel());
        this.setFrame();
    }

    private JPanel prepareMainPanel() {
        // TODO Showing change frame
        // TODO Showing place medicine
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(600, 600));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(prepareButtonPanel(), BorderLayout.PAGE_END);
        mainPanel.add(prepareShoppingListPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel prepareShoppingListPanel() {
        // TODO ScrollPane
        JPanel medicineListPanel = new JPanel();
        medicineListPanel.setLayout(new BorderLayout());
        medicineListPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        medicineListPanel.add(medicineList);
        return medicineListPanel;
    }



    private JPanel prepareButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prepareAddButton());
        buttonPanel.add(prepareTakeButton());
        buttonPanel.add(prepareDeleteButton());
        buttonPanel.add(prepareClearButton());
        buttonPanel.add(prepareSaveButton());
        buttonPanel.add(prepareLoadButton());
        return buttonPanel;
    }

    private JButton prepareAddButton() {
        JButton tmpButton = new JButton("Add ");
        tmpButton.addActionListener((ActionEvent e) -> {
            String productName = com.DialogLibrary.showProductInputDialog();
            try {
                if (!productName.isEmpty()) {
                    medicineList.addElement(productName);
                    return;
                }
                com.DialogLibrary.showEmptyInputDialog();
            } catch (NullPointerException ne) {
            }
        });
        return tmpButton;
    }

    private JButton prepareClearButton() {
        JButton tmpButton = new JButton("Clear");
        tmpButton.addActionListener((ActionEvent e) -> medicineList.clearList());
        return tmpButton;
    }

    private JButton prepareDeleteButton() {
        JButton tmpButton = new JButton("Delete ");
        tmpButton.addActionListener((ActionEvent e) -> {
            if (medicineList.isNotSelected()) {
                com.DialogLibrary.showNotSelectedDialog();
                return;
            }
            medicineList.deleteSelectedElement();
        });
        return tmpButton;
    }

    private JButton prepareTakeButton() {
        JButton tmpButton = new JButton("Take");
        tmpButton.addActionListener((ActionEvent e) -> {
            if (medicineList.isNotSelected()) {
                com.DialogLibrary.showNotSelectedDialog();
                return;
            }
            String response = com.DialogLibrary.showTimeInputDialog();
            try {
                if (!response.isEmpty()) {
                    medicineList.timeSelectedElement(Integer.parseInt(response));
                    return;
                }
                com.DialogLibrary.showEmptyInputDialog();
            } catch (NullPointerException ne) {
            }
        });
        return tmpButton;
    }

    private JButton prepareSaveButton() {
        JButton tmpButton = new JButton("Save");
        tmpButton.addActionListener((ActionEvent e) -> medicineList.saveListToFile());
        return tmpButton;
    }

    private JButton prepareLoadButton() {
        JButton tmpButton = new JButton("Load");
        tmpButton.addActionListener((ActionEvent e) -> medicineList.loadListFromFile());
        return tmpButton;
    }

    private void setFrame() {
        this.setTitle("Medicine List");
        this.pack();
        this.setVisible(true);
    }


}
