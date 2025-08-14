package com.playvoice.consulting.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class ConsultationByManagerDto {
    private Long sessionId;
    private String userId;
    private LocalDate consultationDate;
    private LocalDateTime localDateTime;
    private Status status;
}
