package com.logonedigital.gestion_stock_g8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Double amount;
    private Date createdAt;
    private Date updatedAt;
    private Boolean status;

    @ManyToMany
    private List<Order> products = new ArrayList<>();
}
