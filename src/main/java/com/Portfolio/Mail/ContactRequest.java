package com.Portfolio.Mail;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Column(length = 1000) // Store longer messages
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date submittedAt = new java.util.Date();

}
