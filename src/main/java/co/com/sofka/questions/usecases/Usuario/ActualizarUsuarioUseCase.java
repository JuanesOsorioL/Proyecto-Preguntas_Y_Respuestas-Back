package co.com.sofka.questions.usecases.Usuario;

import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.UsuarioDTO;
import co.com.sofka.questions.repositories.UsuarioRepository;
import co.com.sofka.questions.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarUsuarioUseCase implements SaveUsuario{
    private final UsuarioRepository usuarioRepository;
    private final MapperUtils mapperUtils;

    public ActualizarUsuarioUseCase(MapperUtils mapperUtils, UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUtils = mapperUtils;
    }


    @Override
    public Mono<Usuario> apply(UsuarioDTO usuarioDTO) {
        Objects.requireNonNull(usuarioDTO.getId(), "Id of the USER is required");
        return usuarioRepository
                .save(mapperUtils.mapperToUsuario(usuarioDTO.getId()).apply(usuarioDTO))
                .map(usuario -> usuario);
    }
}
