/*
package co.com.sofka.questions.usecases.Answer;

import co.com.sofka.questions.Services.EnviarService;
import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.repositories.AnswerRepository;
import co.com.sofka.questions.usecases.Questions.GetUseCase;
import co.com.sofka.questions.utils.Category;
import co.com.sofka.questions.utils.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AddAnswerUseCaseTest {
    @SpyBean
    AddAnswerUseCase addAnswerUseCase;

//    @MockBean
  //  EnviarService mailUseCase;

    @MockBean
    GetUseCase getUseCase;

    @MockBean
    AnswerRepository answerRepository;

    @Test
    void addAnswerTest() {
        var questio = new Question("XXX",
                "User1",
                "Que es Linux",
                Type.OPEN,
                Category.SCIENCES,
                "juanesosorio@gmail.com");

        var answerDTO = new AnswerDTO("YYY",
                "XXX",
                "User1",
                "Es un sistema operativo");

        var answer = new Answer("YYY",
                "User1",
                "XXX",
                "Es un sistema operativo", 1);

        Mockito.when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(Mono.just(answer));
        Mockito.when(getUseCase.apply(Mockito.anyString())).thenReturn(Mono.just(questio));

        var questionDTO = addAnswerUseCase.apply(answerDTO);
        var resultQuestionDTO = questionDTO.block();

        assert resultQuestionDTO != null;
        Assertions.assertEquals(resultQuestionDTO.getId(),questio.getId());
        Assertions.assertEquals(resultQuestionDTO.getQuestion(),questio.getQuestion());
        Assertions.assertEquals(resultQuestionDTO.getAnswers().get(0).getQuestionId(),answerDTO.getQuestionId());
       // Assertions.assertEquals(resultQuestionDTO.getAnswers().get(0).getAnswer(),answerDTO.getAnswer());

        Mockito.verify(answerRepository,Mockito.times(1)).save(any());
    }
}
*/
