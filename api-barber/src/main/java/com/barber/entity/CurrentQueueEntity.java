package com.barber.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "current_queue")
public class CurrentQueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_tel", nullable = false)
    private String customerTel;

    @Column(name = "queue_at", nullable = false)
    private LocalDateTime queueAt;
}

