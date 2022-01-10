package co.com.sofka.questions.usecases.Usuario;

import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.UsuarioDTO;
import co.com.sofka.questions.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class CreateUsuarioUseCaseTest {

    @SpyBean
    private CreateUsuarioUseCase createUsuarioUseCase;

    @MockBean
    private UsuarioRepository repository;

    @Test
    void crearUsuarioUseCaseTest() {

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

        when(repository.findUsuarioByUid(any(String.class))).thenReturn(Mono.just(usuario));
        when(repository.save(any())).thenReturn(Mono.just(usuario));
        var result = createUsuarioUseCase.apply(usuariodto);
        Assertions.assertEquals(Objects.requireNonNull(result.block()),usuario);
    }
}