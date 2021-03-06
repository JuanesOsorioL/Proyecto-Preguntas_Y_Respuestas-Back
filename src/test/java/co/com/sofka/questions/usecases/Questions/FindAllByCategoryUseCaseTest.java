package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.repositories.QuestionRepository;
import co.com.sofka.questions.utils.Category;
import co.com.sofka.questions.utils.MapperUtils;
import co.com.sofka.questions.utils.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class FindAllByCategoryUseCaseTest {

    @MockBean
    QuestionRepository repository;

    @SpyBean
    FindAllByCategoryUseCase useCase;

    @BeforeEach
    public void setup(){
        MapperUtils mapperUtils = new MapperUtils();
        repository = mock(QuestionRepository.class);
        useCase = new FindAllByCategoryUseCase(mapperUtils, repository);
    }

    @Test
    void findAllByCategoryListTest() {

        var question = new Question("XXX",
                "User1",
                "Que es Linux",
                Type.OPEN,
                Category.SCIENCES,
                "juanesosorio@gmail.com");

        when(repository.findAllByCategory(question.getCategory().toString())).thenReturn(Flux.just(question));

        StepVerifier.create(useCase.apply(question.getCategory().toString()))
                .expectNextMatches(questionDTO -> {
                    assert questionDTO.getUserId().equals("User1");
                    assert questionDTO.getCategory().equals(Category.SCIENCES);
                    assert questionDTO.getQuestion().equals("Que es Linux");
                    assert questionDTO.getType().equals(Type.OPEN);
                    return true;
                })
                .verifyComplete();
        verify(repository).findAllByCategory(question.getCategory().toString());
    }
}
