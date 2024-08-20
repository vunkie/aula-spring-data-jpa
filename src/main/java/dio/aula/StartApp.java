package dio.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // insertUser();
        List<User> users = repository.findByNameContaining("Doe");

        for (User u : users) {
            System.out.println(u.getName());
        }

        User user = repository.findByUsername("john.doe");
        System.out.println(user.getName());
        
        for (User u : repository.findAll()) {
            System.out.println(u.getUsername());
        }
    }

    private void insertUser(){
        User user = new User();
        user.setName("Maria Pereira");
        user.setUsername("per.maria");
        user.setPassword("87654321");
        repository.save(user);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }

}
