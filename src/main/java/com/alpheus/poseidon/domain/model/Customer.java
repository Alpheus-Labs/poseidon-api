package com.alpheus.poseidon.domain.model;

import com.alpheus.poseidon.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
public class Customer {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public void encryptPassword() {
        this.password = PasswordUtils.encrypt(this.password);
    }
}
