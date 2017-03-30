/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.controllers;

import br.com.algartelecom.artec.spring.daos.PessoaDAO;
import br.com.algartelecom.artec.spring.models.Pessoa;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leandro
 */
@RestController
public class PessoaController {

    @RequestMapping(path = "/inserePessoa")
    public void inserePessoa(@RequestBody Pessoa pessoa) {
        PessoaDAO pd = new PessoaDAO();
        pd.setPessoa(pessoa);
        pd.insert();
    }
}
