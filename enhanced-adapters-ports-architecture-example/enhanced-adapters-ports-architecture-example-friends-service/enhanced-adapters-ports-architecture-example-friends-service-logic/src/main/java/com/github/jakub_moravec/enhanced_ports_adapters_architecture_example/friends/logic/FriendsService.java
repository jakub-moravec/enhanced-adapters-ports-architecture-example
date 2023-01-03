package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.logic;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.FriendsInputPort;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model.FriendDTO;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.model.Friend;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.repositoryport.FriendsRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FriendsService implements FriendsInputPort {

    private final FriendsRepositoryPort friendsServiceRepository;

    @Override
    public List<FriendDTO> listFriends(String fullName) {
        List<Friend> friends;
        if (fullName == null) {
            friends = friendsServiceRepository.listFriends(null, null);
        } else {
            String[] nameParts = fullName.split(" ");
            friends = friendsServiceRepository.listFriends(nameParts[0], nameParts[1]);
        }

        return friends.stream()
                .map(friend -> new FriendDTO(friend.getNick(), friend.getFirstName() + " " + friend.getLastName()))
                .collect(Collectors.toList());
    }
}
