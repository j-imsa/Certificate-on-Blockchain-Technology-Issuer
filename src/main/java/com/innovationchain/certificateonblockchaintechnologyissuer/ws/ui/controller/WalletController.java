package com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.controller;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.service.WalletService;
import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.request.WalletRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/create")
    public String createWallet(@RequestBody WalletRequestModel walletRequestModel) {
        return walletService.createNewWallet(walletRequestModel.getPassword(), walletRequestModel.getDirectory());
    }

    @PostMapping("/load")
    public String loadWallet(@RequestBody WalletRequestModel walletRequestModel) {
        return walletService.loadWallet(walletRequestModel.getPassword(), walletRequestModel.getDirectory(), walletRequestModel.getName());
    }
}
