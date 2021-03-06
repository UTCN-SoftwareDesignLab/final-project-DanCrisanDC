package moviesApp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages ={"moviesApp.model"})
@SpringBootApplication(scanBasePackages = {"moviesApp.application", "moviesApp.model", "moviesApp.repository", "moviesApp.service", "moviesApp.controller", "moviesApp.dto", "moviesApp.config"})
@EnableJpaRepositories(basePackages = {"moviesApp.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}