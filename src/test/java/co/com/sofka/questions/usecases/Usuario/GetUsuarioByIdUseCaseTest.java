package co.com.sofka.questions.usecases.Usuario;

import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

@SpringBootTest
class GetUsuarioByIdUseCaseTest {
    @MockBean
    private UsuarioRepository repository;
    @SpyBean
    private GetUsuarioByIdUseCase useCase;

    @Test
    public void ObtenerUsuarioUseCaseTest(){

        var usuario= new Usuario("QQQ",
                "123456789",
                "carlos",
                "lopera",
                "juanes_1989@gmail.com",
                "rutaphoto");

        Mockito.when(repository.findUsuarioByUid(Mockito.any(String.class))).thenReturn(Mono.just(usuario));
        var onePerson = useCase.apply("123456789");
        Assertions.assertEquals(onePerson.block().getUid(), usuario.getUid());
    }
}