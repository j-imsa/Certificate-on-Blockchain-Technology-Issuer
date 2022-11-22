package com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConnectionModel {
    private long clientId;
    private String clientVersion;
    private String jsonRpc;
}
