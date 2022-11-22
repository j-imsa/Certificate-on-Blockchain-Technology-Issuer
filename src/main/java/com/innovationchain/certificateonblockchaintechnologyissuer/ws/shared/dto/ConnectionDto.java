package com.innovationchain.certificateonblockchaintechnologyissuer.ws.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConnectionDto {
    private long id;
    private long clientId;
    private String clientVersion;
    private String jsonRpc;
}
