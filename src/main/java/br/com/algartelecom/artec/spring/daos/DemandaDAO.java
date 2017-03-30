/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.daos;

import br.com.algartelecom.artec.spring.models.Demanda;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class DemandaDAO {

    private EntityManager entityManager;
    private Demanda demanda;

    public Demanda getDemanda() {
        return demanda;
    }

    public void setDemanda(Demanda demanda) {
        this.demanda = demanda;
    }

    public void insert() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        demanda.setId(null);
        entityManager.persist(this.demanda);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(this.demanda.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void get() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        this.demanda = entityManager.find(Demanda.class, this.demanda.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Demanda> list() {
        List<Demanda> demandas;

        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        demandas = entityManager.createQuery("from Demanda", Demanda.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return demandas;
    }
}
