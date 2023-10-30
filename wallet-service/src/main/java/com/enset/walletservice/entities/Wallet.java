package com.enset.walletservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Wallet {
    @Id
    private String id;
    private float solde;
    private Date creationDate;
    private String devise;
    @ManyToOne
    private Client client;
}
