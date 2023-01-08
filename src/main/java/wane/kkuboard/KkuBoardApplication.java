package wane.kkuboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KkuBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkuBoardApplication.class, args);
    }

}
