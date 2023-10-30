package com.enset.transferservice.entities;

import com.enset.transferservice.enums.TransferStatus;

import com.enset.transferservice.model.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Wallet walletSource;

    @Transient
    private Wallet walletDest;

    private float montant;

    @Enumerated(EnumType.STRING)
    private TransferStatus status;
}
