package com.absolute.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    //todo Расходящиеся модификации 2.1
    public enum Status {

        SUCCESS {
            @Override
            public Purchase.Status toPurchaseStatus() {
                return Purchase.Status.PAID;
            }
        },
        FAILED {
            @Override
            public Purchase.Status toPurchaseStatus() {
                return Purchase.Status.FAILED;
            }
        },
        PENDING {
            @Override
            public Purchase.Status toPurchaseStatus() {
                return Purchase.Status.PENDING;
            }
        };

        public abstract Purchase.Status toPurchaseStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
