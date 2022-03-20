package controller;

import model.Packages;
import model.Vacations;
import service.VacationService;
import view.ViewVacations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class UserController {
    ViewVacations viewVacations = new ViewVacations();
    VacationService vacationService = new VacationService();

    public List<Vacations> filterPackagesByName(){
        return (List<Vacations>) vacationService.getVacationsService().stream().filter((vacations1 -> vacations1.getDestination().equals(viewVacations.getDestinationFilterTextField().getText()))).collect(Collectors.toList());
    }


    public void updateAvailablePackages(List<Vacations> vacations){
        DefaultTableModel dtm = new DefaultTableModel(1, 7);
        dtm.removeRow(0);
        JTable table = viewVacations.getAvailablePackagesList();
        //List<Vacations> vacations = vacationService.getVacationsService();
        String[] row1 = {"Destination", "Name", "Start date", "End date", "Price", "Extra details", "Status"};
        dtm.addRow(row1);
        for (Vacations v:vacations) {
            for (Packages p : v.getPackagesArrayList()) {
                String[] row = {v.getDestination(), p.getName(), p.getStartDate().toString(), p.getEndDate().toString(), String.valueOf(p.getPrice()), p.getExtraDetails(), String.valueOf(p.getPackageStatus())};
                dtm.addRow(row);
            }
        }
        table.setModel(dtm);
    }

    public UserController(){
        List<Vacations> vacations = vacationService.getVacationsService();
        updateAvailablePackages(vacations);

        viewVacations.getFilterByDestiantionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAvailablePackages(filterPackagesByName());
            }
        });

        viewVacations.getFilterByStartDateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = new DefaultTableModel(1, 7);
                dtm.removeRow(0);
                JTable table = viewVacations.getAvailablePackagesList();
                String[] row1 = {"Destination", "Name", "Start date", "End date", "Price", "Extra details", "Status"};
                Date startDate;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                dtm.addRow(row1);
                try{
                    startDate = formatter.parse(viewVacations.getStartDateFieldJTextField().getText());
                    for (Vacations v:vacations) {
                        for (Packages p : v.getPackagesArrayList()) {
                            if(p.getStartDate().after(startDate) ) {
                                String[] row = {v.getDestination(), p.getName(), p.getStartDate().toString(), p.getEndDate().toString(), String.valueOf(p.getPrice()), p.getExtraDetails(), String.valueOf(p.getPackageStatus())};
                                dtm.addRow(row);
                            }
                        }
                    }
                    table.setModel(dtm);
                }
                catch (Exception e1){
                    System.out.println("Please enter e number, not a string");
                }
            }
        });

        viewVacations.getFilterByEndDateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = new DefaultTableModel(1, 7);
                dtm.removeRow(0);
                JTable table = viewVacations.getAvailablePackagesList();
                String[] row1 = {"Destination", "Name", "Start date", "End date", "Price", "Extra details", "Status"};
                Date endDate;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                dtm.addRow(row1);
                try{
                    endDate = formatter.parse(viewVacations.getEndDataJTextField().getText());
                    for (Vacations v:vacations) {
                        for (Packages p : v.getPackagesArrayList()) {
                            if(p.getEndDate().before(endDate) ) {
                                String[] row = {v.getDestination(), p.getName(), p.getStartDate().toString(), p.getEndDate().toString(), String.valueOf(p.getPrice()), p.getExtraDetails(), String.valueOf(p.getPackageStatus())};
                                dtm.addRow(row);
                            }
                        }
                    }
                    table.setModel(dtm);
                }
                catch (Exception e1){
                    System.out.println("Please enter e number, not a string");
                }
            }
        });

        viewVacations.getFilterByPriceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = new DefaultTableModel(1, 7);
                dtm.removeRow(0);
                JTable table = viewVacations.getAvailablePackagesList();
                String[] row1 = {"Destination", "Name", "Start date", "End date", "Price", "Extra details", "Status"};
                int filterPrice = 0;
                dtm.addRow(row1);
                try{
                    filterPrice = Integer.parseInt( viewVacations.getPriceFilterTextFilter().getText());
                }
                catch (Exception e1){
                    System.out.println("Please enter e number, not a string");
                }
                for (Vacations v:vacations) {
                    for (Packages p : v.getPackagesArrayList()) {
                        if(p.getPrice() < filterPrice) {
                            String[] row = {v.getDestination(), p.getName(), p.getStartDate().toString(), p.getEndDate().toString(), String.valueOf(p.getPrice()), p.getExtraDetails(), String.valueOf(p.getPackageStatus())};
                            dtm.addRow(row);
                        }
                    }
                }
                table.setModel(dtm);
            }
        });
    }

}
