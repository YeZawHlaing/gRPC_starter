package org.backend.apigateway.grpcClient;


import com.example.grpc.CreateWalletRequest;
import com.example.grpc.WalletResponse;
import com.example.grpc.WalletServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


@Service
public class WalletGrpcClient {

    @GrpcClient("wallet-service")
    private WalletServiceGrpc.WalletServiceBlockingStub walletStub;

    public WalletResponse getBalance(Long userId) {
        CreateWalletRequest request = CreateWalletRequest.newBuilder()
                .setUserId(userId)
                .build();

        return walletStub.createWallet(request);
    }
}