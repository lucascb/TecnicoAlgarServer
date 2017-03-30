/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring;

import br.com.algartelecom.artec.spring.daos.EMF;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author leandro
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        EMF.setUp();
        SpringApplication.run(Application.class, args);
    }
}
