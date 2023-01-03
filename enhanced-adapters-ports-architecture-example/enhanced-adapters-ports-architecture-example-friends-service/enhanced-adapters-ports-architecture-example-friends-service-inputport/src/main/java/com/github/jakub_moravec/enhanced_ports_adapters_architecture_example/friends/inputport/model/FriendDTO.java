package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE) // for Jackson
@Getter
public class FriendDTO {

    private final String nick;

    private final String fullName;
}
