package br.com.leilaoapp.cliente.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

import br.com.leilaoapp.cliente.model.Cliente;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String razaoSocial;
    private String cpfCnpj;
    private String email;

    public ClienteDTO(Cliente cliente) {
        if(cliente != null) {
            this.id = cliente.getId();
            this.nome = cliente.getNome();
            this.razaoSocial = cliente.getRazaoSocial();
            this.cpfCnpj = cliente.getCpfCnpj();
            this.email = cliente.getEmail();
        }
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}

