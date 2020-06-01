package com.api.gateway.model;

import lombok.Data;

import javax.persistence.*;

/*created by Buddhi*/

@Data
@Entity
@Table(schema = "api", name = "request_trace")
public class RequestTrace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
}