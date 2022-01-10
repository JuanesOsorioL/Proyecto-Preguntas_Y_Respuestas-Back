package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.repositories.AnswerRepository;
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

@SpringBootTest
class DeleteUseCaseTest {

    @MockBean
    private AnswerRepository answerRepository;
    @MockBean
    private QuestionRepository questionRepository;

    @SpyBean
    DeleteUseCase deleteQuestionUseCase;

    @Test
    void deleteUseCase(){
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
        Mockito.when(questionRepository.deleteById("xxxx")).thenReturn(Mono.empty());
        Mockito.when(answerRepository.deleteByQuestionId("xxxx")).thenReturn(Mono.empty());
        var result = deleteQuestionUseCase.apply("xxxx").block();
        Assertions.assertNull(result);
        Mockito.verify(answerRepository,Mockito.times(1)).deleteByQuestionId("xxxx");
    }
}
