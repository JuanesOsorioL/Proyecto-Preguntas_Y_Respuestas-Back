package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.repositories.QuestionRepository;
import co.com.sofka.questions.utils.Category;
import co.com.sofka.questions.utils.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateUseCaseTest {

    @SpyBean
    private CreateUseCase createUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void createQuestion() {
        var questionDT0 = new QuestionDTO("User1",
                "Que es Linux",
                Type.OPEN,
                Category.SCIENCES,
                "juanesosorio@gmail.com");
        var question = new Question("XXX",
                "User1",
                "Que es Linux",
                Type.OPEN,
                Category.SCIENCES,
                "juanesosorio@gmail.com");
        when(repository.save(Mockito.any())).thenReturn(Mono.just(question));
        var result = createUseCase.apply(questionDT0);
        Assertions.assertEquals(Objects.requireNonNull(result.block()),"XXX");
        Assertions.assertEquals(result.block(),question.getId());
        Mockito.verify(repository,Mockito.times(1)).save(any());
    }
}
