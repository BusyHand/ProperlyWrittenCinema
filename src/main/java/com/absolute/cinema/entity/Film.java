package com.absolute.cinema.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "films")
public class Film {
    //todo Расходящиеся модификации 2
    @Getter
    public enum AgeRating {
        ZERO_PLUS("0+", 0),
        SIX_PLUS("6+", 6),
        TWELVE_PLUS("12+", 12),
        SIXTEEN_PLUS("16+", 16),
        EIGHTEEN_PLUS("18+", 18);

        private final String label;
        private final int minAge;

        AgeRating(String label, int minAge) {
            this.label = label;
            this.minAge = minAge;
        }

        @JsonValue
        public String getLabel() {
            return label;
        }

        @JsonCreator
        public static AgeRating fromLabel(String label) {
            return Arrays.stream(values())
                    .filter(r -> r.label.equals(label))
                    .findFirst()
                    .orElseThrow(() ->
                            new IllegalArgumentException("Unknown age rating: " + label));
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(
            nullable = false,
            columnDefinition = "text"
    )
    private String description;

    @Column(
            name = "duration_minutes",
            nullable = false
    )
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "age_rating",
            nullable = false
    )
    private AgeRating ageRating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poster_id")
    private Media poster;

    @CreationTimestamp
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
