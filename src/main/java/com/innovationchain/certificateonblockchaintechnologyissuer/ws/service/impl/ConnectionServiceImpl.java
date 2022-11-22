package com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.impl;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.exception.ConnectionServiceException;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.io.ConnectionRepository;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.io.entity.ConnectionEntity;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.ConnectionService;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.shared.dto.ConnectionDto;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.response.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    final ConnectionRepository connectionRepository;

    public ConnectionServiceImpl(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }


    @Override
    public ConnectionDto createNewWeb3jClient(String url) {
        try {
            Web3j web3 = Web3j.build(new HttpService(url));
            Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();

            ConnectionEntity connectionEntity = new ConnectionEntity();
            connectionEntity.setClientVersion(web3ClientVersion.getWeb3ClientVersion());
            connectionEntity.setClientId(web3ClientVersion.getId());
            connectionEntity.setJsonRpc(web3ClientVersion.getJsonrpc());

            ConnectionEntity storedConnection = connectionRepository.save(connectionEntity);

            ConnectionDto returnValue = new ConnectionDto();
            BeanUtils.copyProperties(storedConnection, returnValue);

            return returnValue;

        } catch (Exception exception) {
            throw new ConnectionServiceException(ErrorMessages.CONNECTION_ERROR.getErrorMessage());
        }
    }

    @Override
    public List<ConnectionDto> getConnections() {
        try {

            return connectionRepository.findAll().stream()
                    .map(connectionEntity -> {
                        ConnectionDto connectionDto = new ConnectionDto();
                        BeanUtils.copyProperties(connectionEntity, connectionDto);
                        return connectionDto;
                    })
                    .collect(Collectors.toList());

        } catch (Exception exception) {
            throw new ConnectionServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
}
