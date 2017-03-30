/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.daos;

import br.com.algartelecom.artec.spring.models.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class PessoaDAO {

    private EntityManager entityManager;
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void insert() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(this.pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void get() {
        entityManager = EMF.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        this.pessoa = entityManager.find(Pessoa.class, this.pessoa.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
