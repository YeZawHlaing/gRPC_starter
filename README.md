# gRPC Microservices Demo with( Spring Boot)

A simple demonstration project that shows how to build microservices communication using **gRPC** in **Spring Boot**.

This project contains two independent services:

- User Service
- Wallet Service

The main goal of this repository is to demonstrate:

- gRPC server setup
- gRPC client setup
- Inter-service communication using Protocol Buffers
- Multi-module Maven project structure
- Shared `.proto` contract usage
- Clean dependency organization from the root project

---

# Architecture

```text
client
   |
   v
User Service  ----gRPC---->  Wallet Service
```
---

# Flow Example

```text
1.Client requests user profile
2.User Service fetches user information
3.User Service calls Wallet Service using gRPC
4.Wallet Service returns wallet balance
5.User Service combines data and returns response
```
---

# Technologies Used

<p align="left">
  <img src="https://skillicons.dev/icons?i=java,spring,maven,mysql" />
</p>

| Technology | Description |
|---|---|
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="20"/> Java 21 | Main programming language |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="20"/> Spring Boot | Backend framework |
| <img src="https://grpc.io/img/logos/grpc-icon-color.png" width="20"/> gRPC | High-performance RPC communication |
| <img src="https://protobuf.dev/img/protobuf-logo.svg" width="20"/> Protocol Buffers | Serialization mechanism for gRPC |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="20"/> Maven | Dependency management and build tool |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="20"/> MySQL | Relational database |
| <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="20"/> Spring Data JPA | Database ORM layer |

---
# Project Structure
```text

grpc-demo/
│
├── pom.xml                     # Root dependency management
│
├── proto/                      # Shared protobuf contract
│   └── src/main/proto/
│
├── user-service/               # User microservice
│
├── wallet-service/             # Wallet microservice
│
└── README.md

```
---
# Purpose of Root project

The root project is mainly responsible for organizing:

- Common dependency versions
- gRPC dependencies
- protobuf plugin versions
- Maven plugin management
- Shared build configuration

This avoids duplicated dependency declarations in every microservice.

---
# gRPC overview

gRPC is a high-performance RPC framework developed by Google.

Instead of REST APIs using JSON, gRPC uses:

- HTTP/2
- Protocol Buffers (protobuf)
- Binary serialization

Advantages:

- Faster communication
- Smaller payload size
- Strongly typed contracts
- Better performance between microservices

---
# Shared Proto Module

The proto module contains all .proto files.
example:
```text

syntax = "proto3";

package wallet;

service WalletService {
  rpc GetWalletByUserId (WalletRequest)
      returns (WalletResponse);
}

message WalletRequest {
  int64 userId = 1;
}

message WalletResponse {
  double balance = 1;
}
```
---
# Author

Developed by Ye Zaw Hlaing

GitHub:
https://github.com/YeZawHlaing

---
