package co.com.sofka.questions.model;

import co.com.sofka.questions.utils.Category;
import co.com.sofka.questions.utils.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionPhotoDTO {
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String question;
    @NotNull
    private Type type;
    @NotNull
    private Category category;
    @NotBlank
    private String email;
    private String Photo;
    private List<AnswerDTO> answers;


    public QuestionPhotoDTO() {

    }

    public QuestionPhotoDTO(String id, String userId, String question, Type type, Category category, String email, List<AnswerDTO> answers) {
        this.id = id;
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
        this.email = email;
        this.answers = answers;
    }

    public QuestionPhotoDTO(String id, String userId, String question, Type type, Category category, String email) {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
