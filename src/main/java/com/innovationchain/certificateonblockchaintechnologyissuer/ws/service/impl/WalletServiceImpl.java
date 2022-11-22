package com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.impl;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.exception.WalletServiceException;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.WalletService;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.response.ErrorMessages;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;

import java.io.File;

@Service
public class WalletServiceImpl implements WalletService {


    @Override
    public String createNewWallet(String password, String directory) {
        try {
            String walletName = WalletUtils.generateNewWalletFile(password, new File(directory));
            return directory + "/" + walletName;
        } catch (Exception exception) {
            throw new WalletServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
        }
    }

    @Override
    public String loadWallet(String password, String directory, String name) {
        try {
            Credentials credentials = WalletUtils.loadCredentials(password, directory + "/" + name);

            ECKeyPair privateKey = credentials.getEcKeyPair();
            System.out.println("Private Key:  " + privateKey.getPrivateKey().toString(16));
            System.out.println("Public Key:  " + privateKey.getPublicKey().toString(16));

            return credentials.getAddress();

        } catch (Exception exception) {
            throw new WalletServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
}
