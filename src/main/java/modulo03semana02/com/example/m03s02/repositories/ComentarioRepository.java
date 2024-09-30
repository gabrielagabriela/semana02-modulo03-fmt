package modulo03semana02.com.example.m03s02.repositories;

import modulo03semana02.com.example.m03s02.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
