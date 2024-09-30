package modulo03semana02.com.example.m03s02.repositories;


import modulo03semana02.com.example.m03s02.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestaoRepository  extends JpaRepository<Sugestao, Long> {
}
