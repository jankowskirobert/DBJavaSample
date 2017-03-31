/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;

import com.accenture.communicationdistribution.model.Emply;
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
    public String sayIt(String message) {
        EntityManager entityManager = getEntityManager();
        try {
            Emply en = new Emply();
            en.setName("asf");
            en.setLastName("asf");
            en.setJob("asdas");
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.getTransaction().begin();
                entityManager.persist(en);
                entityManager.getTransaction().commit();
            }
            System.out.println(" HERE");
        } catch (NullPointerException ex) {
            System.err.println(ex);
        } finally {
            entityManager.close();
        }
        return data += message;
    }

    @Override
    public String getMsg() {
        return data;
    }
    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("jpa-example");
        }
        return emf.createEntityManager();
    }
}
