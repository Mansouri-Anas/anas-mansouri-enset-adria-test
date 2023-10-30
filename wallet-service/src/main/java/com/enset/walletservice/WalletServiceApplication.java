package com.enset.walletservice;

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
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(WalletRepository walletRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Wallet.class);
        return args -> {
            Client client = new Client(null,"anas","anas@gmail.com",null);
            clientRepository.save(client);
            Wallet wallet = new Wallet();
            wallet.setId(UUID.randomUUID().toString());
            wallet.setDevise("USD");
            wallet.setCreationDate(new Date());
            wallet.setSolde(new Random().nextFloat(10000));
            wallet.setClient(client);
            walletRepository.save(wallet);
        };
    }

}
