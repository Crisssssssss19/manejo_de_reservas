package com.cris.manejo_de_reservas.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ErrorMessage{
    private Integer status;
    private String message;
    private LocalDateTime localDateTime;

}
