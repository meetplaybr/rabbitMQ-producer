package br.com.leilaoapp.cliente.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
  
  @GetMapping
  @PreAuthorize("hasAuthority('SCOPE_read')")
  public String list(){
    return "olá";
  }
}
