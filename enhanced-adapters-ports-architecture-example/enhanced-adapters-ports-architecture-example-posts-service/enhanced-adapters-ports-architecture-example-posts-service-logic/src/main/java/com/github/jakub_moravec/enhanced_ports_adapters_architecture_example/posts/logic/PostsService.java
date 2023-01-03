package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.logic;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.FriendsInputPort;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model.FriendDTO;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.inputport.PostsInputPort;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.posts.repositoryport.PostsRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService implements PostsInputPort {

    private final PostsRepositoryPort postsRepositoryPort;

    private final FriendsInputPort friendsInputPort;

    @Override
    public List<String> listPosts(String userNick) {
        return postsRepositoryPort.listPosts(userNick);
    }

    @Override
    public List<String> listPostsByName(String fullName) {
        List<FriendDTO> friends = friendsInputPort.listFriends(fullName);
        return friends.stream()
                .map(friend -> postsRepositoryPort.listPosts(friend.getNick()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
