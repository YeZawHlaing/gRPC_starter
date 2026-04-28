package org.backend.walletservice.grpc;

import com.example.grpc.CreateWalletRequest;
import com.example.grpc.WalletResponse;
import com.example.grpc.WalletServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.backend.walletservice.service.WalletService;

@GrpcService
@RequiredArgsConstructor
public class WalletGrpcService extends WalletServiceGrpc.WalletServiceImplBase{

    //WalletServiceGrpc.WalletServiceImplBase
    private final WalletService walletService;

    @Override
    public void createWallet(CreateWalletRequest request,
                           StreamObserver<WalletResponse> responseObserver) {

        var wallet = walletService.getWallet(request.getUserId());

        WalletResponse response = WalletResponse.newBuilder()
                .setId(wallet.getUserId())
                .setBalance(wallet.getBalance())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
