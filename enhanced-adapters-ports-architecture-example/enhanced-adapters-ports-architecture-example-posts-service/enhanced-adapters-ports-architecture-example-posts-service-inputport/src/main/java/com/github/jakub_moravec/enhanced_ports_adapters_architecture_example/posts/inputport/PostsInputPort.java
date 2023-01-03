package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.inputport;

import java.util.List;

public interface PostsInputPort {

    /**
     * Searches posts by user unique id - nickname. The Posts service contains all necessary information for this operation.
     *
     * @param userNick user nickname
     * @return filtered posts
     */
    List<String> listPosts(String userNick);

    /**
     * Searches posts by user name. The Posts service needs to call the Friends service for this operation.
     *
     * @param fullName user name
     * @return filtered posts
     */
    List<String> listPostsByName(String fullName);

}
