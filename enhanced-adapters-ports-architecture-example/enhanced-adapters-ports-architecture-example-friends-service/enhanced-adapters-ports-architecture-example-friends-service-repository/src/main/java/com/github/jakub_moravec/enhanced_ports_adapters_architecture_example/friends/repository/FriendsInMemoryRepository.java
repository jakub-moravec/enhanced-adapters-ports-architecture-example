package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.repository;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.model.Friend;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.repositoryport.FriendsRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FriendsInMemoryRepository implements FriendsRepositoryPort {

    private final List<Friend> friends = List.of(
            new Friend("johndoe", "John", "Doe"),
            new Friend("janedoe", "Jane", "Doe")
    );

    @Override
    public List<Friend> listFriends(String firstName, String lastName) {
        return friends.stream()
                .filter(friend -> (firstName == null || friend.getFirstName().equals(firstName)) &&
                        (lastName == null || friend.getLastName().equals(lastName)))
                .collect(Collectors.toList());
    }
}
