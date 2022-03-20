package view;

import javax.swing.*;

public class EditVacations extends JFrame{
    private JTabbedPane destinationTabbedPane;
    private JPanel panel1;
    private JTextField addDestinationTextField;
    private JButton addButton;
    private JComboBox destinationComboBox;
    private JTextField addNameTextField;
    private JTextField addPriceTextField;
    private JTextField startDateTextField;
    private JTextField addExtraDetailsTextField;
    private JTextField addEmptySpotsTextField;
    private JButton addPackageButton;
    private JTextField editSpotsAvailable;
    private JTextField editStartDateTextField;
    private JTextField editExtraDetailsTextField;
    private JTextField editPriceTextField;
    private JTextField editNameTextField;
    private JButton editButton;
    private JButton deleteButton;
    private JComboBox selectPackageComboBox;
    private JTable viewPackagesTable;
    private JTextField endDateTextField;
    private JTextField editEndDateTextField;
    private JComboBox deleteDestinationComboBox;
    private JButton deleteDestinationButton;

    public EditVacations(){
        super("Edit data");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        this.setBounds(100,100,600,700);
        this.setVisible(true);
    }

    public JTextField getEditStartDateTextField() {
        return editStartDateTextField;
    }

    public JTextField getEditEndDateTextField() {
        return editEndDateTextField;
    }

    public JTextField getAddDestinationTextField(){
        return addDestinationTextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JComboBox getDestinationComboBox() {
        return destinationComboBox;
    }

    public JTextField getAddNameTextField() {
        return addNameTextField;
    }

    public JTextField getAddPriceTextField() {
        return addPriceTextField;
    }

    public JTextField getAddPeriodTextField() {
        return startDateTextField;
    }

    public JTextField getAddExtraDetailsTextField() {
        return addExtraDetailsTextField;
    }

    public JTextField getAddEmptySpotsTextField() {
        return addEmptySpotsTextField;
    }

    public JButton getAddPackageButton() {
        return addPackageButton;
    }

    public JTextField getEditSpotsAvailable() {
        return editSpotsAvailable;
    }

    public JTextField getEditPeriodTextField() {
        return editStartDateTextField;
    }

    public JTextField getEditExtraDetailsTextField() {
        return editExtraDetailsTextField;
    }

    public JTextField getEditPriceTextField() {
        return editPriceTextField;
    }

    public JTextField getEditNameTextField() {
        return editNameTextField;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JComboBox getSelectPackageComboBox() {
        return selectPackageComboBox;
    }

    public JTable getViewPackagesTable() {
        return viewPackagesTable;
    }

    public JTextField getStartDateTextField() {
        return startDateTextField;
    }

    public JTextField getEndDateTextField() {
        return endDateTextField;
    }

    public void setViewPackagesTable(JTable viewPackagesTable) {
        this.viewPackagesTable = viewPackagesTable;
    }

    public JComboBox getDeleteDestinationComboBox() {
        return deleteDestinationComboBox;
    }

    public JButton getDeleteDestinationButton() {
        return deleteDestinationButton;
    }
}
