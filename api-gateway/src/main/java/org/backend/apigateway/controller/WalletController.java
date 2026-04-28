package org.backend.apigateway.controller;


import com.example.grpc.WalletResponse;
import lombok.RequiredArgsConstructor;
import org.backend.apigateway.dto.responseDto.WalletResponseDto;
import org.backend.apigateway.grpcClient.WalletGrpcClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletGrpcClient walletGrpcClient;

    @GetMapping("/{userId}")
    public WalletResponseDto getBalance(@PathVariable("userId") Long userId) {

        var response = walletGrpcClient.getBalance(userId);

        return WalletResponseDto.builder()
                .userId(response.getId())
                .balance(response.getBalance())
                .build();
    }
}
