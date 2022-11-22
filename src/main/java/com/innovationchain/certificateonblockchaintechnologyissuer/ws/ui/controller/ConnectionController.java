package com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.controller;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.ConnectionService;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.shared.dto.ConnectionDto;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.request.ConnectionUrl;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.response.ConnectionModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/connection")
public class ConnectionController {

    final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }


    @PostMapping
    public ConnectionModel startConnection(@RequestBody ConnectionUrl connectionUrl) {
        ConnectionModel returnValue = new ConnectionModel();

        ConnectionDto connectionDto = connectionService.createNewWeb3jClient(connectionUrl.getUrl());
        BeanUtils.copyProperties(connectionDto, returnValue);

        return returnValue;
    }

    @GetMapping
    public List<ConnectionModel> getConnectionModel() {

        List<ConnectionDto> connectionDtos = connectionService.getConnections();

        return connectionDtos.stream()
                .map(connectionDto -> {
                    ConnectionModel connectionModel = new ConnectionModel();
                    BeanUtils.copyProperties(connectionDto, connectionModel);
                    return connectionModel;
                })
                .collect(Collectors.toList());
    }


}
