/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.algartelecom.artec.spring.controllers;

import br.com.algartelecom.artec.spring.daos.PessoaDAO;
import br.com.algartelecom.artec.spring.models.Pessoa;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author leandro
 */
@RestController
public class ClienteController {

    @RequestMapping(path = "/notificaCliente", method = RequestMethod.GET)
    public void notificaCliente(HttpServletResponse response, @RequestParam(value = "id", required = true) Long id) {
        String ACCOUNT_SID = "AC0c8466ac13b0292b5555657de9e382c3";
        String AUTH_TOKEN = "b404e20924dda15041d8dcb9ca9c2e77";

        Pessoa cliente = new Pessoa();
        PessoaDAO clienteDao = new PessoaDAO();

        cliente.setId(id);
        clienteDao.setPessoa(cliente);
        clienteDao.get();

        StringBuilder sb = new StringBuilder();
        sb.append("Ola ");
        sb.append(clienteDao.getPessoa().getNome());
        sb.append(", um tecnico estara chegando em sua residencia dentro de 30 minutos. Gostaria de confirmar?");
        String mensagem = sb.toString();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            Call call = Call.creator(new PhoneNumber("+5534991890302"), new PhoneNumber("+5534991890302"),
                    new URI("http://twimlets.com/echo?Twiml=%3CResponse%3E%0A%20%20%20%20%3CSay%20voice%3D%22alice%22%20language%3D%22pt-BR%22%20loop%3D%223%22%20%3E%20Algar%20Telecom%20avisa%20%3A%20Verifique%20suas%20mensagens%20SMS%3C%2FSay%3E%0A%3C%2FResponse%3E&")).create();
            System.out.println(call.getSid());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        response.setHeader("Location", "https://atendimentodigital3.mybluemix.net/start?text=" + mensagem);
    }

        
}
