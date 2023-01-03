package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model.FriendDTO;

import java.util.List;

public interface FriendsInputPort {

     List<FriendDTO> listFriends(String fullName);
}
