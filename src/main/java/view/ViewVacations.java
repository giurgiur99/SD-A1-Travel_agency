package view;

import javax.swing.*;

public class ViewVacations extends  JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JRadioButton periodRadioButton;
    private JRadioButton priceRadioButton;
    private JRadioButton destinationRadioButton;
    private JTable availablePackagesList;
    private JList bookedVactionsList;
    private JTextField destinationFilterTextField;
    private JTextField priceFilterTextFilter;
    private JButton filterByDestiantionButton;
    private JButton filterByPriceButton;
    private JTextField startDateFieldJTextField;
    private JTextField endDataJTextField;
    private JButton filterByStartDateButton;
    private JButton filterByEndDateButton;
    private ButtonGroup buttonGroup;

    public ViewVacations(){
        super();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        this.setBounds(100,100,600,700);
        this.setVisible(true);


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(periodRadioButton);
        buttonGroup.add(priceRadioButton);
        buttonGroup.add(destinationRadioButton);

    }

    public JRadioButton getDestinationRadioButton() {
        return destinationRadioButton;
    }

    public JTable getAvailablePackagesList() {
        return availablePackagesList;
    }

    public JList getBookedVactionsList() {
        return bookedVactionsList;
    }

    public JTextField getDestinationFilterTextField() {
        return destinationFilterTextField;
    }

    public JTextField getPriceFilterTextFilter() {
        return priceFilterTextFilter;
    }

    public JButton getFilterByDestiantionButton() {
        return filterByDestiantionButton;
    }

    public JButton getFilterByPriceButton() {
        return filterByPriceButton;
    }

    public JTextField getStartDateFieldJTextField() {
        return startDateFieldJTextField;
    }

    public JTextField getEndDataJTextField() {
        return endDataJTextField;
    }

    public JButton getFilterByStartDateButton() {
        return filterByStartDateButton;
    }

    public JButton getFilterByEndDateButton() {
        return filterByEndDateButton;
    }
}

