package modulo03semana02.com.example.m03s02.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sugestao")
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sugestao_id")
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime data_envio;

    private LocalDateTime data_atualizacao;


}
