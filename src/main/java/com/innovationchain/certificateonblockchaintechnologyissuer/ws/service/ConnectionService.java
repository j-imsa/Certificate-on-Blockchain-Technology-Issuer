package com.innovationchain.certificateonblockchaintechnologyissuer.ws.service;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.shared.dto.ConnectionDto;

import java.util.List;

public interface ConnectionService {
    ConnectionDto createNewWeb3jClient(String url);

    List<ConnectionDto> getConnections();
}
