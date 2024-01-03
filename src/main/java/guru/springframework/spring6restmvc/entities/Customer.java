package guru.springframework.spring6restmvc.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    private UUID id;
    private String name;

    @Version
    private Integer version;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
}
