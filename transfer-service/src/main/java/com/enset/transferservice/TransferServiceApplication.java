package com.enset.transferservice;

import com.enset.transferservice.entities.Transfer;
import com.enset.transferservice.enums.TransferStatus;
import com.enset.transferservice.feign.WalletRestClient;
import com.enset.transferservice.repositories.TransferRepository;
import com.enset.walletservice.entities.Client;
import com.enset.walletservice.entities.Wallet;
import com.enset.walletservice.repository.ClientRepository;
import com.enset.walletservice.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class TransferServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(TransferRepository transferRepository, WalletRestClient walletRestClient, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Transfer.class);
        return args -> {
    Transfer transfer = new Transfer();
    transfer.setMontant(2000);
    transfer.setStatus(TransferStatus.PENDING);
    transfer.setWalletDest(null);
    transfer.setWalletSource(null);
    transferRepository.save(transfer);
        };
    }
}
