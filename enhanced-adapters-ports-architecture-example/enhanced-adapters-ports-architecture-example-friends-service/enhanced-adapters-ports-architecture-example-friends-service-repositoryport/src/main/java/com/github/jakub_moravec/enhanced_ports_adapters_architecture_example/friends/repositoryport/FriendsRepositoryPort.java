package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.repositoryport;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.model.Friend;

import java.util.List;

public interface FriendsRepositoryPort {

    List<Friend> listFriends(String firstName, String lastName);
}
