package io.github.fernandaditanno;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Usuarios usuarios) {
        return args -> {
           System.out.println("Listando usuarios");
           // usuarios.save(new Usuario("Fernanda", "fernanda@teste.com", "senha", "senha"));

            usuarios.findAll().forEach(u -> System.out.println(u));
        };
    }

    public static void main(String[] args){
        SpringApplication.run(LoginApplication.class, args);
    }
}
