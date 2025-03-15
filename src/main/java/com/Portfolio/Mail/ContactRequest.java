package com.Portfolio.Mail;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactRequest {

    private Long id;
    private String name;
    private String email;

    private String message;

    private java.util.Date submittedAt = new java.util.Date();

}
