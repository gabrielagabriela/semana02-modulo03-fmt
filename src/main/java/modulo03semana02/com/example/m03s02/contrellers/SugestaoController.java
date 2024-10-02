package modulo03semana02.com.example.m03s02.contrellers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import modulo03semana02.com.example.m03s02.entities.Sugestao;
import modulo03semana02.com.example.m03s02.services.SugestaoService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sugestoes")
@Tag(name = "Sugestão - CRUD", description = "CRUD de sugestões")
public class SugestaoController {

    private final SugestaoService service;

    public SugestaoController(SugestaoService service) {
        this.service = service;
    }

    @Operation(description = "Buscar todas as sugestões cadastradas", summary = "buscar todos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sugestões encontradas",
                    useReturnTypeSchema = true
            ),
    })
    @GetMapping
    public ResponseEntity<List<Sugestao>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @Operation(description = "Buscar a sugestão pelo ID", summary = "buscar por ID")
    @GetMapping("{id}")
    @Parameter(description = "Id da sugestão")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Encontrado",
                    content = @Content(schema = @Schema(implementation = Sugestao.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Não encontrado",
                    content = @Content(schema = @Schema(implementation = ChangeSetPersister.NotFoundException.class))
            )
    })
    public ResponseEntity<Sugestao> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @Operation(description = "Criação de uma sugestão", summary = "Criar sugestão")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Sugestão criada",
                    useReturnTypeSchema = true
            ),
    })
    @PostMapping
    public ResponseEntity<Sugestao> criar(@RequestBody Sugestao sugestao){
        return ResponseEntity.status(HttpStatus.OK).body(service.criar(sugestao));
    }
}

