package com.innovationchain.certificateonblockchaintechnologyissuer.ws.io.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@Entity(name = "connection")
public class ConnectionEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long clientId;

    @Column(nullable = false)
    private String clientVersion;

    @Column(nullable = false)
    private String jsonRpc;
}
