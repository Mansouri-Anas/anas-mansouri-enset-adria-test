package com.enset.transferservice.model;

import lombok.Data;

import java.util.Date;
@Data
public class Wallet {
    private String id;
    private float solde;
    private Date creationDate;
    private String devise;
}
