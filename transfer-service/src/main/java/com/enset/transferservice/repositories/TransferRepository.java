package com.enset.transferservice.repositories;

import com.enset.transferservice.entities.Transfer;
import com.enset.walletservice.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
