package controller;

import model.Packages;
import model.Vacations;
import service.VacationService;
import view.EditVacations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

public class VacationController{
    EditVacations editVacations = new EditVacations();
    VacationService vacationService = new VacationService();

    public void refreshComboBox(){
        List<Vacations> vacationsArrayList = vacationService.getVacationsService();
        editVacations.getDestinationComboBox().removeAllItems();
        vacationsArrayList.forEach(vacations -> editVacations.getDestinationComboBox().addItem(vacations));
        List<Packages> packagesList = vacationService.getAllPackagesService();
        editVacations.getSelectPackageComboBox().removeAllItems();
        packagesList.forEach(packages -> editVacations.getSelectPackageComboBox().addItem(packages));
    }

    public void populateJTable(){
        DefaultTableModel dtm = new DefaultTableModel(1, 6);
        dtm.removeRow(0);
        JTable table = editVacations.getViewPackagesTable();
        List<Packages> packages = vacationService.getAllPackagesService();
        String[] row1 = {"Name", "Start date", "End date", "Price", "Extra details", "Status"};
        dtm.addRow(row1);
        for (Packages p:packages){
            String[] row = {p.getName(), p.getStartDate().toString(), p.getEndDate().toString(), String.valueOf(p.getPrice()), p.getExtraDetails(), String.valueOf(p.getPackageStatus())};
            dtm.addRow(row);
        }
        table.setModel(dtm);
    }

    public void populateDestinationComboBox(){
        editVacations.getDeleteDestinationComboBox().removeAllItems();
        List<Vacations> vacationsArrayList = vacationService.getVacationsService();
        vacationsArrayList.forEach(vacation -> editVacations.getDeleteDestinationComboBox().addItem(vacation));
    }

    public VacationController(){

        refreshComboBox();

        populateJTable();

        editVacations.getDeleteDestinationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vacationService.deleteVacationByDestinationService((Vacations) editVacations.getDeleteDestinationComboBox().getSelectedItem());
                populateDestinationComboBox();
                populateJTable();
            }
        });

        populateDestinationComboBox();

        editVacations.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Packages packages = (Packages) editVacations.getSelectPackageComboBox().getSelectedItem();
                vacationService.deletePackageService(packages);
                refreshComboBox();
                populateJTable();

            }
        });


        editVacations.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Packages packages = (Packages) editVacations.getSelectPackageComboBox().getSelectedItem();
                int emptySpots = parseInt( editVacations.getEditSpotsAvailable().getText());
                int price = parseInt(editVacations.getEditPriceTextField().getText());
                String name = editVacations.getEditNameTextField().getText();
                String extraDetails = editVacations.getEditExtraDetailsTextField().getText();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try{
                    Date startDate = formatter.parse(editVacations.getEditStartDateTextField().getText());
                    Date endDate = formatter.parse(editVacations.getEditEndDateTextField().getText());
                    vacationService.editPackageService(packages, name, emptySpots, startDate, endDate, extraDetails, price);
                    refreshComboBox();
                    populateJTable();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });

        editVacations.getAddPackageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //27-11-2022
                populateDestinationComboBox();
                Vacations selectedVacation = (Vacations) editVacations.getDestinationComboBox().getSelectedItem();
                System.out.println(selectedVacation);
                int price = parseInt(editVacations.getAddPriceTextField().getText());
                String extraDetails = editVacations.getAddExtraDetailsTextField().getText();
                int emptySpots = parseInt( editVacations.getAddEmptySpotsTextField().getText());
                String name = editVacations.getAddNameTextField().getText();
                Packages.PackageStatus packageStatus = Packages.PackageStatus.NOT_BOOKED;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                //Parsing the given String to Date object
                try {
                    Date startDate = formatter.parse(editVacations.getStartDateTextField().getText());
                    Date endDate = formatter.parse(editVacations.getEndDateTextField().getText());
                    Packages newPackages = new Packages(price, name, startDate, endDate, extraDetails, emptySpots, packageStatus);
                    System.out.println(newPackages.getName() + " " + newPackages.getId());
                    vacationService.addPackagesService(selectedVacation, newPackages);
                    refreshComboBox();
                    populateJTable();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

            }
        });


        editVacations.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vacationService.addVacationService(editVacations.getAddDestinationTextField().getText());
                populateJTable();
                refreshComboBox();

            }
        });

    }

}
