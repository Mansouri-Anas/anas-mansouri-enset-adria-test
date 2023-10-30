package com.enset.transferservice.feign;


import com.enset.walletservice.entities.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "WALLET-SERVICE")
public interface WalletRestClient {
    @GetMapping(path = "/wallets/{id}")
    Wallet getWalletById(@PathVariable(name = "id") Long id);

}
