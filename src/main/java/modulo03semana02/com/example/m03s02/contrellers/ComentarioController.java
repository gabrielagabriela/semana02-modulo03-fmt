package modulo03semana02.com.example.m03s02.contrellers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import modulo03semana02.com.example.m03s02.entities.Comentario;
import modulo03semana02.com.example.m03s02.entities.Sugestao;
import modulo03semana02.com.example.m03s02.services.ComentarioService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comentarios")
@Tag(name = "Comentário - CRUD", description = "CRUD de comentários")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @Operation(description = "Buscar todos os comentários cadastrados", summary = "buscar todos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Comentários encontrados",
                    useReturnTypeSchema = true
            ),
    })
    @GetMapping
    public ResponseEntity<List<Comentario>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }


    @Operation(description = "Buscar comentários pelo ID", summary = "buscar por ID")
    @GetMapping("{id}")
    @Parameter(description = "Id do comentário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Encontrado",
                    content = @Content(schema = @Schema(implementation = Comentario.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Não encontrado",
                    content = @Content(schema = @Schema(implementation = ChangeSetPersister.NotFoundException.class))
            )
    })
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @Operation(description = "Criação de um comentário", summary = "Criar comentário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Comentário criado!",
                    useReturnTypeSchema = true
            ),
    })
    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.OK).body(service.criar(comentario));
    }
}
