package co.com.sofka.questions.usecases.Usuario;

import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.UsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveUsuario {
    Mono<Usuario> apply(@Valid UsuarioDTO usuarioDTO);
}