package com.logonedigital.gestion_stock_g8.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReqDTO {
    @NotEmpty(message = "please fill this !")
    @NotNull(message = "This field can't be null")
    private String firstname;
    private String lastname;
    @Email(message = "email isn't correct")
    private String email;
    private LocationReqDTO locationReqDTO;
}
