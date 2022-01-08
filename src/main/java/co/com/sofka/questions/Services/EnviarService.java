package co.com.sofka.questions.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class EnviarService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final String FROM = "sofkacorreo@gmail.com";

    public EnviarService() {
    }

    public Mono<String> sendMail(String to, String subject, String body){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(FROM);
        System.out.println(to);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

        return Mono.just("¡Send!");
    }
}
