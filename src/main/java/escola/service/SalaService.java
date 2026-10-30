
package escola.service;

import escola.model.Sala;
import escola.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public Sala cadastrar(Sala sala) {

        if (repository.existsByCodigo(sala.getCodigo())) {
            throw new ConflitoException("Código já cadastrado");
        }

        sala.setReservada(false);

        return repository.save(sala);
    }

    public List<Sala> listar() {
        return repository.findAll();
    }

    public Sala buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new SalaNaoEncontradaException(
                        "Sala não encontrada"));
    }

    public Sala reservar(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new ConflitoException(
                "Esta sala já está reservada");
        }

        sala.setReservada(true);

        return repository.save(sala);
    }

    public Sala liberar(Long id) {

        Sala sala = buscarPorId(id);

        if (!sala.isReservada()) {
            throw new ConflitoException(
                "Esta sala já está livre");
        }

        sala.setReservada(false);

        return repository.save(sala);
    }

    public void excluir(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new ConflitoException(
                "Não é possível excluir uma sala reservada");
        }

        repository.delete(sala);
    }
}
