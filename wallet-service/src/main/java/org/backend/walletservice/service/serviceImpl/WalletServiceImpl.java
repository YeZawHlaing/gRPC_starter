package org.backend.walletservice.service.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.backend.walletservice.entity.Wallet;
import org.backend.walletservice.repository.WalletRepository;
import org.backend.walletservice.service.WalletService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public Wallet getWallet(Long userId) {
        return walletRepository.findById(userId)
                .orElse(Wallet.builder()
                        .userId(userId)
                        .balance(0.0)
                        .build());
    }
}
