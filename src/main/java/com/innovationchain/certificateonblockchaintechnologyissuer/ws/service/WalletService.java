package com.innovationchain.certificateonblockchaintechnologyissuer.ws.service;

public interface WalletService {
    String createNewWallet(String password, String directory);

    String loadWallet(String password, String directory, String name);
}
