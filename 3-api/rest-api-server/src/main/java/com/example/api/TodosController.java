package com.example.api;

import com.example.resource.Todo;
import com.example.resource.TodoType;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {

    private static final Map<Integer, Todo> todos = new HashMap<>();

    static {
        todos.put(1, new Todo() {{
            setId(1);
            setTitle("Learn Akka");
            setCompleted(false);
            setType(TodoType.WORK);
        }});
        todos.put(2, new Todo() {{
            setId(2);
            setTitle("Learn Spring Boot");
            setCompleted(false);
            setType(TodoType.WORK);
        }});
        todos.put(3, new Todo() {{
            setId(3);
            setTitle("Learn Life");
            setCompleted(false);
            setType(TodoType.HOME);
        }});
        todos.put(4, new Todo() {{
            setId(4);
            setTitle("Learn Cooking");
            setCompleted(false);
            setType(TodoType.OTHER);
        }});
    }

    //----------------------------------------------------------
    // read
    //----------------------------------------------------------

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Todo> getTodos() {
        return todos.values();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = {"limit"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Todo> getTodosByLimit(@RequestParam("limit") int limit) {
        return todos.values().stream().limit(limit).collect(Collectors.toList());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = {"type"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Todo> getTodosByType(@RequestParam("type") String type) {
        return todos.values().stream().filter(todo -> todo.getType().equals(TodoType.valueOf(type.toUpperCase()))).collect(Collectors.toList());
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getTodoById(@PathVariable("id") int id) {
        Todo todo = todos.get(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            throw new NotFoundException(id);
        }
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.HEAD
    )
    public ResponseEntity<?> headTodos(@PathVariable("id") int id) {
        HttpHeaders headers = new HttpHeaders();
        if (todos.get(id) != null) {
            headers.add("exist", "true");
        } else {
            headers.add("exist", "false");
        }
        return ResponseEntity.noContent().headers(headers).build();
    }


    //----------------------------------------------------------
    // write
    //----------------------------------------------------------

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> postTodo(@RequestBody Todo todo) throws URISyntaxException {
        todo.setId(todos.size() + 1);
        todos.put(todo.getId(), todo);
        return ResponseEntity.created(new URI("" + todo.getId())).body(todo);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createOrUpdateTodo(@PathVariable int id, @RequestBody Todo todo) throws URISyntaxException {
        boolean isExist = todos.containsKey(id);
        if (!isExist) {
//           todo.setId(todos.size() + 1);
//           todos.put(todo.getId(), todo);
//           return ResponseEntity.created(new URI(""+todo.getId())).body(todo);
            throw new NotFoundException(id);
        } else {
            todo.setId(id);
            todos.put(id, todo);
            return ResponseEntity.ok(todo);
        }
    }

    @DeleteMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> deleteTodoById(@PathVariable("id") int id) {
        Todo todo = todos.get(id);
        if (todo != null) {
            todos.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new NotFoundException(id);
        }
    }


}
