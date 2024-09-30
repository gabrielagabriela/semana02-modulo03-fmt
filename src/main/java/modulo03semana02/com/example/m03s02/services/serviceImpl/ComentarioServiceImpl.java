package modulo03semana02.com.example.m03s02.services.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import modulo03semana02.com.example.m03s02.entities.Comentario;
import modulo03semana02.com.example.m03s02.repositories.ComentarioRepository;
import modulo03semana02.com.example.m03s02.services.ComentarioService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;



    @Override
    public Comentario criar(Comentario comentario) {

        comentario.setId(null);
        return comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> buscarTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID: " + id));
    }

    @Override
    public Comentario atualizar(Long id, Comentario comentario) {
        buscarPorId(id);
        comentario.setId(id);
        return comentarioRepository.save(comentario);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        comentarioRepository.deleteById(id);
    }
}
