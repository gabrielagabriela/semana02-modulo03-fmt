package modulo03semana02.com.example.m03s02.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comentario_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sugestao_id")
    private Sugestao sugestaoId;

    private String texto;

    private LocalDateTime data_envio;

}
