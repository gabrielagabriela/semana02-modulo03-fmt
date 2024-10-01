package modulo03semana02.com.example.m03s02.contrellers;


import modulo03semana02.com.example.m03s02.entities.Sugestao;
import modulo03semana02.com.example.m03s02.services.SugestaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sugestoes")
public class SugestaoController {

    private final SugestaoService service;

    public SugestaoController(SugestaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sugestao>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Sugestao> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Sugestao> criar(@RequestBody Sugestao sugestao){
        return ResponseEntity.status(HttpStatus.OK).body(service.criar(sugestao));
    }
}
