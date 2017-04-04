/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;

import com.accenture.communicationdistribution.model.RssMessages;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author r.jankowski
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES,
        value = 20)
public class NewSessionBean implements IBean {

    private String data = "D: ";

    public NewSessionBean() {

    }

    @Override
    public boolean addEmployee(String name, String lastName, String job) {
        EntityManager entityManager = getEntityManager();
        try {
            RssMessages en = new RssMessages();
            en.setTitle("Car Accident");
            en.setLink("https://wp.pl");
            en.setDescription("Big car accident");
            en.setPublicationDate(new Date());
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.getTransaction().begin();
                entityManager.persist(en);
                entityManager.getTransaction().commit();
                return true;
            }
            System.out.println(" HERE");
        } catch (NullPointerException ex) {
            System.err.println(ex);
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public RssMessages getEmployee(int id) {
        EntityManager entityManager = getEntityManager();
        RssMessages emp = null;
        try {
            if (entityManager != null && entityManager.isOpen()) {
                emp = entityManager.find(RssMessages.class, id);
            }
        } catch (NullPointerException ex) {
            System.err.println(ex);
        } finally {
            entityManager.close();
        }
        return emp;
    }
    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("jpa-example");
        }
        return emf.createEntityManager();
    }
}
