package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.repositories.QuestionRepository;
import co.com.sofka.questions.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ListPhotoUseCase {
    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public ListPhotoUseCase(QuestionRepository questionRepository, MapperUtils mapperUtils) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }


}
