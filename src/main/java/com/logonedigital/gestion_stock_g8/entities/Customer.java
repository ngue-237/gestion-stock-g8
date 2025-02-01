package com.logonedigital.gestion_stock_g8.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @NotEmpty(message = "please fill this !")
    @NotNull(message = "This field can't be null")
    private String firstname;
    private String lastname;
    @Email(message = "email isn't correct")
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private Boolean status;

    @OneToOne
    private Location location;

}
