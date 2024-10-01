package modulo03semana02.com.example.m03s02.contrellers;


import modulo03semana02.com.example.m03s02.entities.Comentario;
import modulo03semana02.com.example.m03s02.services.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comentarios")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.OK).body(service.criar(comentario));
    }
}
