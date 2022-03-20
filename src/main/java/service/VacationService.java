package service;

import com.google.inject.internal.ErrorsException;
import model.Packages;
import model.Vacations;
import repository.VacationsRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VacationService {
    VacationsRepository vacationsRepository = new VacationsRepository();

    public void deleteVacationByDestinationService(Vacations vacations){
        vacationsRepository.deleteVacationByDestination(vacations);

    }

    public void editPackageService(Packages packages,String name, int emptySpots, Date startDate, Date endDate, String extraDetails, int price ){
        try{
            packages.setPrice(price);
            packages.setExtraDetails(extraDetails);
            packages.setStartDate(startDate);
            packages.setEndDate(endDate);
            packages.setEmptySpots(emptySpots);
            packages.setName(name);
            vacationsRepository.editPackage(packages);
        }catch (Exception e){
            System.out.println("\n ! Database could not be updated ! \n");
        }
    }

    public void deletePackageService(Packages packages){
        vacationsRepository.deletePackage(packages);
    }

    public void addVacationService(String destination){
        try{
            vacationsRepository.addDestination(destination);
        }catch (Exception e){
            System.out.println("\n ! Name already exists in this database ! \n");
        }
    }

    public void addPackagesService(Vacations vacation, Packages packages){
        try{
            vacationsRepository.addPackages(vacation, packages);
        }catch (Exception e){
            System.out.println("\n This package already exists \n");
        }
    }
    public List<Packages> getAllPackagesService(){
        try{
            return vacationsRepository.getAllPackages();
        }catch (Exception e){
            System.out.println("\n Package could not be retrived \n");
            return null;
        }
    }

    public void editPackagesService(Packages packages, int emptySpots, Date startDate, Date endDate, String extraDetails, int price){
        if(packages == null){
            throw new Error("Package is null");
        }
        else if (emptySpots < 1){
            throw new Error("Number of empty spots must be bigger than 0");
        }
        else if(startDate.after(endDate)){
            throw new Error("End date must start before end date is over");
        }
        else if (extraDetails.length() < 5){
            throw new Error ("Extra details must have at least 5 chars");
        }
        else if(price < 0){
            throw new Error ("Price must be greater than 0");
        }
        else{
            vacationsRepository.editVacation(packages, emptySpots, startDate, endDate, extraDetails, price);
        }
    }

    public Vacations findVacationByNameService(String name) {
        return vacationsRepository.findVacationByName(name);
    }

    public List<Vacations> getVacationsService(){
        return vacationsRepository.getVacations();
    }
}
