package co.com.sofka.questions.usecases.Usuario;

import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.UsuarioDTO;
import co.com.sofka.questions.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest
class ActualizarUsuarioUseCaseTest {

    @SpyBean
    private ActualizarUsuarioUseCase actualizarUsuarioUseCase;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void updateUsuarioTest() {

        var usuario= new Usuario("QQQ",
                "123456789",
                "carlos",
                "lopera",
                "juanes_1989@gmail.com",
                "rutaphoto");

        var usuariodto= new UsuarioDTO("QQQ",
                "123456789",
                "carlos",
                "lopera",
                "juanes_1989@gmail.com",
                "rutaphoto");

        when(usuarioRepository.save(Mockito.any())).thenReturn(Mono.just(usuario));
        var result = actualizarUsuarioUseCase.apply(usuariodto);

        Assertions.assertEquals(Objects.requireNonNull(result.block()),usuario);
    }
}