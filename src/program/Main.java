/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;


//import java.util.List;
//import javax.swing.JOptionPane;
//import javax.swing.table.TableModel;
//import java.util.Optional;
//import java.time.LocalDate;
//import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;
import entity.*;
import javax.swing.*;

import java.awt.*;


/**
 *
 * @author Gokhan
 */
public class Main extends javax.swing.JFrame {
    public Main() {
        // Window setup
        setTitle("Oak Donuts");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // LEFT PANEL (Filters,Menu ,Options)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null); // absolute layout inside this panel
        leftPanel.setBounds(10, 10, 380, 680);
        leftPanel.setBorder(BorderFactory.createTitledBorder("")); // visual border
        add(leftPanel);

        //RIGHT PANEL (Order table,totals,buttons)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 10, 780, 680);
        rightPanel.setBorder(BorderFactory.createTitledBorder(""));
        add(rightPanel);

        // Left side component

        // Filters label
        JLabel filtersLabel = new JLabel("Filters");
        filtersLabel.setBounds(20, 10, 200, 25);
        leftPanel.add(filtersLabel);

        // Category label and dropdown
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(20, 40, 150, 20);
        leftPanel.add(categoryLabel);

        JComboBox<String> categoryCombo = new JComboBox<>(
                new String[]{"All", "Donuts", "Drinks", "Breakfast"}
        );
        categoryCombo.setBounds(20, 65, 150, 25);
        leftPanel.add(categoryCombo);

        // Search label and text field
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(20, 105, 150, 20);
        leftPanel.add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(20, 130, 200, 25);
        leftPanel.add(searchField);

        // Menu label
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setBounds(20, 170, 200, 25);
        leftPanel.add(menuLabel);

        // Menu list (scrollable)
        String[] menuItems = {
                "Glazed Donut     $1.49",
                "Chocolate Sprinkles  $1.79",
                "Boston Creme     $1.99",
                "House Coffee     $2.00",
                "Latte            $3.00",
                "Breakfast Sandwich   $4.50"
        };

        JList<String> menuList = new JList<>(menuItems);
        JScrollPane menuScroll = new JScrollPane(menuList);
        menuScroll.setBounds(20, 200, 330, 200);
        leftPanel.add(menuScroll);

        // Item Options label
        JLabel optionsLabel = new JLabel("Item Options");
        optionsLabel.setBounds(20, 410, 200, 25);
        leftPanel.add(optionsLabel);

        // Icing option
        JLabel icingLabel = new JLabel("Icing:");
        icingLabel.setBounds(20, 440, 150, 20);
        leftPanel.add(icingLabel);

        JComboBox<String> icingCombo = new JComboBox<>(new String[]{"None", "Chocolate", "Vanilla"});
        icingCombo.setBounds(20, 465, 150, 25);
        leftPanel.add(icingCombo);

        // Filling option
        JLabel fillingLabel = new JLabel("Filling:");
        fillingLabel.setBounds(20, 500, 150, 20);
        leftPanel.add(fillingLabel);

        JComboBox<String> fillingCombo = new JComboBox<>(new String[]{"None", "Caramel", "Strawberry"});
        fillingCombo.setBounds(20, 525, 150, 25);
        leftPanel.add(fillingCombo);

        // Quantity label + field
        JLabel qtyLabel = new JLabel("Qty:");
        qtyLabel.setBounds(20, 565, 40, 20);
        leftPanel.add(qtyLabel);

        JTextField qtyField = new JTextField("1");
        qtyField.setBounds(60, 560, 40, 28);
        leftPanel.add(qtyField);

        // Unit price label (changes when selecting)
        JLabel unitPriceLabel = new JLabel("Unit: $0.00");
        unitPriceLabel.setBounds(120, 560, 100, 25);
        leftPanel.add(unitPriceLabel);

        JButton addToOrderBtn = new JButton("Add to Order");
        addToOrderBtn.setBounds(230, 560, 120, 30);
        leftPanel.add(addToOrderBtn);

        //RIGHT SIDE(Order table, totals)

        // Order table
        String[] columns = {"Item", "Options", "Qty", "Price", "Total"};
        Object[][] tableData = new Object[0][5];

        JTable orderTable = new JTable(tableData, columns);
        JScrollPane orderScroll = new JScrollPane(orderTable);

        orderScroll.setBounds(20, 20, 740, 350);
        rightPanel.add(orderScroll);

        // subtotal
        JLabel subtotalLabel = new JLabel("Subtotal:");
        subtotalLabel.setBounds(540, 380, 100, 25);
        rightPanel.add(subtotalLabel);

        JLabel subtotalValue = new JLabel("$0.00");
        subtotalValue.setBounds(650, 380, 100, 25);
        rightPanel.add(subtotalValue);

        // tax
        JLabel taxLabel = new JLabel("Tax (6%):");
        taxLabel.setBounds(540, 410, 100, 25);
        rightPanel.add(taxLabel);

        JLabel taxValue = new JLabel("$0.00");
        taxValue.setBounds(650, 410, 100, 25);
        rightPanel.add(taxValue);

        // total
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setBounds(540, 440, 100, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(totalLabel);

        JLabel totalValue = new JLabel("$0.00");
        totalValue.setBounds(650, 440, 100, 30);
        totalValue.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(totalValue);

        // Buttons
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(540, 500, 100, 40);
        rightPanel.add(clearBtn);

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.setBounds(650, 500, 120, 40);
        rightPanel.add(checkoutBtn);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main gui = new Main();
            gui.setVisible(true);
        });
    }


}

