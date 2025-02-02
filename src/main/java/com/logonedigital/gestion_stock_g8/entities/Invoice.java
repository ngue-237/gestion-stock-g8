package com.logonedigital.gestion_stock_g8.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, unique = true)
        private String reference;

        private Date createdAt;
        private Date updatedAt;
        private Boolean status;


}
