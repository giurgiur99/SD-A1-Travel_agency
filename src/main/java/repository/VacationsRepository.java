package repository;

import model.Packages;
import model.Vacations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VacationsRepository {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("A1");
    EntityManager em = entityManagerFactory.createEntityManager();

    public void editPackage(Packages packages){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(packages);
        em.getTransaction().commit();
        em.close();
    }

    public void addPackages(Vacations vacation, Packages packages){
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            vacation.addPackage(packages);
            em.persist(packages);
            em.merge(vacation);
            em.getTransaction().commit();
            em.close();

    }

    public List<Packages> getAllPackages(){
        EntityManager em = entityManagerFactory.createEntityManager();
        return (ArrayList<Packages>) em.createQuery("SELECT p FROM Packages p", Packages.class).getResultList();
    }

    public Vacations findVacationByName(String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        return (Vacations) em.createQuery("SELECT v FROM Vacations v WHERE destination=:name", Vacations.class).setParameter("name", name).getSingleResult();
    }


    public List<Vacations> getVacations(){
        EntityManager em = entityManagerFactory.createEntityManager();
        return (ArrayList<Vacations>) em.createQuery("SELECT v FROM Vacations v", Vacations.class).getResultList();
    }

    public void deletePackage(Packages packages){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(packages) ? packages : em.merge(packages));
        em.getTransaction().commit();
        em.close();
    }

    public void addDestination(String destination){
        EntityManager em = entityManagerFactory.createEntityManager();
        Vacations vacation = new Vacations(destination);
        em.getTransaction().begin();
        em.persist(vacation);
        em.getTransaction().commit();
        em.close();
    }

    public void editVacation(Packages packages, int emptySpots, Date startDate, Date endDate, String extraDetails, int price){
        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(packages);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteVacationByDestination(Vacations vacations){
        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(vacations) ? vacations : em.merge(vacations));
        em.getTransaction().commit();
        em.close();
    }

   /* public List<Packages> getPackagesByDestination(){
        return (ArrayList<Packages>) em.createQuery("from Vacations v left join fetch v.packagesId").getResultList();
   }
    */
}
