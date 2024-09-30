package modulo03semana02.com.example.m03s02.services.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import modulo03semana02.com.example.m03s02.entities.Sugestao;
import modulo03semana02.com.example.m03s02.repositories.SugestaoRepository;
import modulo03semana02.com.example.m03s02.services.SugestaoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SugestaoServiceImpl implements SugestaoService {

    private final SugestaoRepository sugestaoRepository;



    @Override
    public Sugestao criar(Sugestao sugestao) {

        sugestao.setId(null);
        return sugestaoRepository.save(sugestao);
    }

    @Override
    public List<Sugestao> buscarTodos() {
        return sugestaoRepository.findAll();
    }

    @Override
    public Sugestao buscarPorId(Long id) {
        return sugestaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID: " + id));
    }

    @Override
    public Sugestao atualizar(Long id, Sugestao sugestao) {
        buscarPorId(id);
        sugestao.setId(id);
        return sugestaoRepository.save(sugestao);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        sugestaoRepository.deleteById(id);
    }
}
