package org.backend.clientservice.grpc;

import com.example.grpc.UserServiceGrpc;
import com.example.grpc.getUserRequest;
import com.example.grpc.userResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.backend.clientservice.service.UserService;

@GrpcService
@RequiredArgsConstructor
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    private final UserService userService;

    @Override
    public void getUser(getUserRequest request,
                        StreamObserver<userResponse> responseObserver) {

        // 🔹 Extract request
        Long userId = request.getUserId();

        // 🔹 Call business logic
        var user = userService.getUser(userId);

        // 🔹 Build response
        userResponse response = userResponse.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .build();

        // 🔹 Send response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}