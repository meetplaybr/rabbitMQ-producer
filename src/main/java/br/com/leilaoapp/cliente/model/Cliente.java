package br.com.leilaoapp.cliente.model;


import lombok.*;

import javax.persistence.*;

import br.com.leilaoapp.cliente.dto.ClienteDTO;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq_cliente")
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "EMAIL")
    private String email;

    /*   @ManyToOne
       @JoinColumn(name = "CR_EMPRESA")
       private Empresa empresa;
   */
    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.nome = clienteDTO.getNome();
        this.razaoSocial = clienteDTO.getRazaoSocial();
        this.cpfCnpj = clienteDTO.getCpfCnpj();
        this.email = clienteDTO.getEmail();
    }


}
