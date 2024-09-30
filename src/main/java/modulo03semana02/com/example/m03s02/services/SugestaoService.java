package modulo03semana02.com.example.m03s02.services;

import modulo03semana02.com.example.m03s02.entities.Sugestao;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SugestaoService {

    Sugestao criar(@RequestBody Sugestao sugestao);

    List<Sugestao> buscarTodos();

    Sugestao buscarPorId(Long id);

    Sugestao atualizar(Long id, @RequestBody Sugestao sugestao);

    void excluir(Long id);
}

