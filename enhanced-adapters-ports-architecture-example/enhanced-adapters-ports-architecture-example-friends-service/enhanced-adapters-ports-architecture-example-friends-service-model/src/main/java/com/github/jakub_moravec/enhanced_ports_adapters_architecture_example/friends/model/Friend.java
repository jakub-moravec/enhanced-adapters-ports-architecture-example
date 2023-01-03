package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Friend {

    private final String nick;

    private final String firstName;

    private final String lastName;
}

