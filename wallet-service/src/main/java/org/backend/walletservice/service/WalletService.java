package org.backend.walletservice.service;

import org.backend.walletservice.entity.Wallet;

public interface WalletService {
    public Wallet getWallet(Long userId);
}
