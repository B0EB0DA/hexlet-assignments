package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

/*
GET /api/users/{id}/posts — список всех постов, написанных пользователем с таким же userId, как id в маршруте

POST /api/users/{id}/posts – создание нового поста, привязанного к пользователю по id.
Код должен возвращать статус 201, тело запроса должно содержать slug, title и body.
Обратите внимание, что userId берется из маршрута
 */

// BEGIN
@RestController
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/api/users/{id}/posts")
    public List<Post> show(@PathVariable String id) {
        var page = posts.stream()
                .filter(p -> p.getUserId() == Integer.valueOf(id))
                .toList();
        return page;
    }

    @PostMapping("/api/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable String id, @RequestBody Post post) {
        post.setUserId(Integer.valueOf(id));
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }


}

// END
