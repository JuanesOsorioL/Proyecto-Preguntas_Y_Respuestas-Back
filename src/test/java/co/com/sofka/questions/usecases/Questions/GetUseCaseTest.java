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

@SpringBootTest
class GetUseCaseTest {

    @MockBean
    private QuestionRepository questionRepository;
    @SpyBean
    private GetUseCase getQuestion;

    @Test
    public void getQuestion(){

        var questionDT0 = new QuestionDTO("User1",
                "Que es Linux",
                Type.OPEN,
                Category.SCIENCES,
                "juanesosorio@gmail.com");

        var question= new Question();
        question.setId("XXX");
        question.setQuestion("Que es Linux");
        question.setUserId("User1");
        question.setType(Type.OPEN);
        question.setCategory(Category.SCIENCES);
        question.setEmail("juanesosorio@gmail.com");

        Mockito.when(questionRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(question));

        var respuesta = getQuestion.apply("XXX");
        Assertions.assertEquals(respuesta.block().getQuestion(), question.getQuestion());
        Assertions.assertEquals(respuesta.block().getId(), question.getId());
        Assertions.assertEquals(respuesta.block().getUserId(), question.getUserId());
        Assertions.assertEquals(respuesta.block().getType(), question.getType());
        Assertions.assertEquals(respuesta.block().getCategory(), question.getCategory());
        Assertions.assertEquals(respuesta.block().getEmail(), question.getEmail());

        Mockito.verify(questionRepository,Mockito.times(1)).findById("XXX");
    }
}
