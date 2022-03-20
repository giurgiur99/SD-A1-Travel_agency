package repository;

import model.Packages;
import model.User;
import model.Vacations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepository {
        private static final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("A1");



    public void addUser(User user){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User userCheckUsername(User user){
        EntityManager em = entityManagerFactory.createEntityManager();
        String name = user.getUsername();
        return (User) em.createQuery("SELECT u FROM User u WHERE username=:name", User.class).setParameter("name", name).getSingleResult();
    }

    public User userCheckPassword(User user){
        EntityManager em = entityManagerFactory.createEntityManager();
        String name = user.getPassword();
        return (User) em.createQuery("SELECT u FROM User u WHERE password=:name", User.class).setParameter("name", name).getSingleResult();
    }

    public User findByUsername(String username){
       // em.getTransaction().begin();
        EntityManager em = entityManagerFactory.createEntityManager();
        return (User) em.createQuery("SELECT u FROM User u WHERE u.username=:username").setParameter("username", username).getSingleResult();
    }

}
