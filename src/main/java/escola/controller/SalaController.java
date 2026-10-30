
package escola.controller;

import escola.model.Sala;
import escola.service.SalaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    // Cadastrar sala
    @PostMapping
    public ResponseEntity<Sala> cadastrar(
            @Valid @RequestBody Sala sala) {

        Sala novaSala = service.cadastrar(sala);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaSala);
    }

    // Listar salas
    @GetMapping
    public ResponseEntity<List<Sala>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    // Buscar sala pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscar(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Reservar sala
    @PutMapping("/{id}/reservar")
    public ResponseEntity<Sala> reservar(@PathVariable Long id) {

        return ResponseEntity.ok(service.reservar(id));
    }

    // Liberar sala
    @PutMapping("/{id}/liberar")
    public ResponseEntity<Sala> liberar(@PathVariable Long id) {

        return ResponseEntity.ok(service.liberar(id));
    }

    // Excluir sala
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
