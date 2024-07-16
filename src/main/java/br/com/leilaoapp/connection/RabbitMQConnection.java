package br.com.leilaoapp.connection;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.leilaoapp.constants.RabbitMQConstantes;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    // Dando om nome para Exchange como amq.direct -> nome default do RabbitMQ
    private static final String NEW_EXCHANGE = "amq.direct";
    // Injetando a class que faz a conexao com o RabbitMQ
    @Autowired
    private AmqpAdmin amqpAdmin;
    // Instanciando a class AmqpAdmin pelo construtor
    // public RabbitMQConnection(AmqpAdmin amqpAdmin){
    //     this.amqpAdmin = amqpAdmin;
    // }
    // Metodo para criar fila
    private Queue fila(String nome){
        return new Queue(nome, true,false, false);
    }
    // Metodo para nomear a Exchange
    private DirectExchange trocaDireta(){
        return new DirectExchange(NEW_EXCHANGE);
    }
    // Metodo para criar Binding entre a fila e a Exchange
    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(),fila.getName(), null);
    }
    // Metodos de instaciam as Filas a Exchange e o Relacionamento entre elas
    // Decrarando Filas e Exchange e relacionamentos, para a classe amqpAdmin
    @PostConstruct
    private void adiciona(){
        Queue preco = this.fila(RabbitMQConstantes.FILA_PRECO);
        DirectExchange troca = this.trocaDireta();
        Binding ligacaoPreco = this.relacionamento(preco, troca);
        amqpAdmin.declareQueue(preco);
        amqpAdmin.declareExchange(troca);
        amqpAdmin.declareBinding(ligacaoPreco);
    }
}
