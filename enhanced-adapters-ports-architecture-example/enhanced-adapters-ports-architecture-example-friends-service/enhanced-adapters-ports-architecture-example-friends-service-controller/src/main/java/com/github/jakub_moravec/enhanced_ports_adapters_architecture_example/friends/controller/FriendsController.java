package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.controller;

import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.FriendsInputPort;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model.FriendDTO;
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
public class FriendsController {

    private FriendsInputPort friendsInputPort;

    @GetMapping(value = "/friends", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<FriendDTO>> getConnections(@RequestParam(value = "fullName", required = false) String fullName){
        return ResponseEntity.ok(friendsInputPort.listFriends(fullName));
    }

}
