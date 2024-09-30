package modulo03semana02.com.example.m03s02.services;

import modulo03semana02.com.example.m03s02.entities.Comentario;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ComentarioService {

    Comentario criar(@RequestBody Comentario comentario);

    List<Comentario> buscarTodos();

    Comentario buscarPorId(Long id);

    Comentario atualizar(Long id, @RequestBody Comentario comentario);

    void excluir(Long id);
}

