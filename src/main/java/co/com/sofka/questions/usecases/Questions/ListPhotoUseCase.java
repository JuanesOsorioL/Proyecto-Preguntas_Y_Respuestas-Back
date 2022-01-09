package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.model.QuestionPhotoDTO;
import co.com.sofka.questions.model.UsuarioDTO;
import co.com.sofka.questions.repositories.QuestionRepository;
import co.com.sofka.questions.repositories.UsuarioRepository;
import co.com.sofka.questions.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Validated
    public class ListPhotoUseCase implements Supplier<Flux<QuestionPhotoDTO>> {
    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;
    private final UsuarioRepository usuarioRepository;

    public ListPhotoUseCase(QuestionRepository questionRepository, MapperUtils mapperUtils, UsuarioRepository usuarioRepository) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Flux<QuestionPhotoDTO> get() {
        return questionRepository.findAll()
                .map(mapperUtils.mapEntityToQuestionPhoto())
                .flatMap(question ->
                    Mono.just(question).zipWith(
                                    usuarioRepository.findUsuarioByUid(question.getUserId())
                                            .map(mapperUtils.mapperToUsuarioDTO()),
                                    (QuestionPhotoDTO, UsuarioDTO)->{
                                        QuestionPhotoDTO.setPhoto(UsuarioDTO.getPath());
                                                return QuestionPhotoDTO;
                                    }
                    )
                );
                //.map(mapperUtils.mapEntityToQuestionPhoto())
                //.flatMap(mapQuestionAggregate());

    }

/*    private Function<QuestionPhotoDTO, Flux<QuestionPhotoDTO>> mapQuestionAggregate() {
        return questionPhotoDTO ->
                Flux.just(questionPhotoDTO).zipWith(
                        usuarioRepository.findUsuarioByUid(questionPhotoDTO.getUserId())
                                .map(mapperUtils.mapperToUsuarioDTO()),
                        (questionPhotoDTO1, usuario) -> {
                            questionPhotoDTO.setPhoto(usuario.getPath());
                            return questionPhotoDTO;
                        }
                );
    }*/

}
