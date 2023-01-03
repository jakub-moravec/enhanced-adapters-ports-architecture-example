package com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.FriendsInputPort;
import com.github.jakub_moravec.enhanced_ports_adapters_architecture_example.friends.inputport.model.FriendDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FriendsClient implements FriendsInputPort {

    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    private final String friendsServiceUrl;

    public FriendsClient(RestTemplateBuilder restTemplateBuilder, @Value("${example.friends.service.get.friends.url}") String friendsServiceUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.friendsServiceUrl = friendsServiceUrl;
        mapper = new ObjectMapper();
    }

    @Override
    public List<FriendDTO> listFriends(String fullName) {
        TypeReference<List<FriendDTO>> typeReference = new TypeReference<>() {};
        String requestUrl = friendsServiceUrl + "?fullName=" + fullName;
        String response = this.restTemplate.getForObject(requestUrl, String.class);
        try {
            return mapper.readValue(response, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
