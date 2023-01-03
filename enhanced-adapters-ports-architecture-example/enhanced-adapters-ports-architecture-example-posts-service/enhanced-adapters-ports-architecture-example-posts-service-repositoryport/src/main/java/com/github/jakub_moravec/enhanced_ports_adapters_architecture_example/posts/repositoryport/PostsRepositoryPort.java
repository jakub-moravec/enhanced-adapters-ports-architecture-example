package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.repositoryport;

import java.util.List;

public interface PostsRepositoryPort {

    List<String> listPosts(String userNick);
}
