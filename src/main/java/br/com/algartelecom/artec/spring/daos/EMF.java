/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leandro
 */
public class EMF {
    private static EntityManagerFactory entityManagerFactory;

    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ArtecPU");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
