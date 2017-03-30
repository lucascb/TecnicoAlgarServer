/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.controllers;

import br.com.algartelecom.artec.spring.daos.DemandaDAO;
import br.com.algartelecom.artec.spring.models.Demanda;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author leandro
 */
@RestController
public class DemandaController {

    @RequestMapping(path = "/criaDemanda", method = RequestMethod.POST)
    public void criaDemanda(@RequestBody Demanda demanda) {
        DemandaDAO demandaDao = new DemandaDAO();
        demandaDao.setDemanda(demanda);
        demandaDao.insert();

    }

    @RequestMapping(path = "/obtemDemandas", method = RequestMethod.GET)
    public @ResponseBody List<Demanda> obtemDemandas() {
        DemandaDAO demandaDao = new DemandaDAO();
        ArrayList<Demanda> demandas;

        demandas = (ArrayList<Demanda>) demandaDao.list();

        return demandas;
    }
}
