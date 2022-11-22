package com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WalletRequestModel {
    private String directory;
    private String password;
    private String name;
}
