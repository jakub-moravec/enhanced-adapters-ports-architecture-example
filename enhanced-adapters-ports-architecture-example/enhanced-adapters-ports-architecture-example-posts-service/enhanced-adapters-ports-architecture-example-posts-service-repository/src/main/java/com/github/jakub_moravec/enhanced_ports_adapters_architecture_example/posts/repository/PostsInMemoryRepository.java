package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.repository;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.repositoryport.PostsRepositoryPort;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostsInMemoryRepository implements PostsRepositoryPort {

    private final LinkedMultiValueMap<String, String> posts;

    public PostsInMemoryRepository() {
        this.posts = new LinkedMultiValueMap<>();
        posts.add("johndoe", "Joe's first ever post");
        posts.add("janedoe", "Jane's first ever post");
        posts.add("janedoe", "Jane's next post");
    }

    @Override
    public List<String> listPosts(String userNick) {
        if (userNick == null) {
            return posts.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        }

        return posts.get(userNick);
    }
}
