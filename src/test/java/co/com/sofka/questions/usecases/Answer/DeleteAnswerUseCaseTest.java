package co.com.sofka.questions.usecases.Answer;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.repositories.AnswerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

@SpringBootTest
class DeleteAnswerUseCaseTest {

    @MockBean
    private AnswerRepository repository;

    @SpyBean
    private DeleteAnswerUseCase useCase;

    @Test
    void deleteAnswerUseCaseTest(){

        var answerDTO = new AnswerDTO("XXX",
                "YYY",
                "User1",
                "Sistema operativo");
        var answer = new Answer("XXX",
                "User1",
                "YYY",
                "Sistema operativo",
                1);

        Mockito.when(repository.deleteById("XXX")).thenReturn(Mono.empty());
        Mockito.when(repository.deleteByQuestionId("XXX")).thenReturn(Mono.empty());

        var result = useCase.apply("XXX").block();
        Assertions.assertNull(result);
}
}