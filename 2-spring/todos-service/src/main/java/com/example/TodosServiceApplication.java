package com.example;

import com.example.entity.Todo;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;

@SpringBootApplication
public class TodosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            MongoTemplate mongoTemplate,
            MongoOperations mongoOperations,
            TodoRepository todoRepository,
            UserRepository userRepository
    ) {
        return args -> {


//            mongoTemplate.findAll(Todo.class).forEach(System.out::println);
//            mongoOperations.findAll(Todo.class).forEach(System.out::println);


//            userRepository.findAll().forEach(System.out::println);

//
//            todoRepository.findByStatus(false)
//                    .forEach(System.out::println);


            for (int i = 5001; i < 10000; i++) {
                Todo todo = new Todo();
                todo.setTitle("Todo " + i);
                todo.setCompleted(false);
                todoRepository.save(todo);
            }

            System.out.println("done");

        };
    }

}
