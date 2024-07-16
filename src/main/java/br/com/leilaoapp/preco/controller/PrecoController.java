package br.com.leilaoapp.preco.controller;

import br.com.leilaoapp.constants.RabbitMQConstantes;
import br.com.leilaoapp.preco.dto.PrecoDTO;
import br.com.leilaoapp.preco.service.RabbitMQService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("preco")
public class PrecoController {
    
    @Autowired
    private RabbitMQService rabbitMQService;
    
    @PutMapping
    private ResponseEntity<?> alteraPreco(@RequestBody PrecoDTO precoDTO){
        System.out.println(precoDTO.codigoProduto);
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
