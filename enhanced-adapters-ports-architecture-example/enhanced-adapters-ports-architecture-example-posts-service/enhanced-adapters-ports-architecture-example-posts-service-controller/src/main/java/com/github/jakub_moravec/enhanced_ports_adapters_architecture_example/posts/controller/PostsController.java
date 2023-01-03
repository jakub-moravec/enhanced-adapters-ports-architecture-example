package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.controller;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.inputport.PostsInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internal/v1")
@AllArgsConstructor
public class PostsController {

    private PostsInputPort postsInputPort;

    @GetMapping(value = "/posts", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<String>> getConnections(@RequestParam(value = "nickname", required = false) String nickname,
                                                       @RequestParam(value = "fullName", required = false) String fullName){
        if (fullName != null) {
            return ResponseEntity.ok(postsInputPort.listPostsByName(fullName));
        } else {
            return ResponseEntity.ok(postsInputPort.listPosts(nickname));
        }
    }
}
