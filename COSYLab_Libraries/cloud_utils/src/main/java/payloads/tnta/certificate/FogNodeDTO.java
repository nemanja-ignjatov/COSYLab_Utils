package payloads.tnta.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FogNodeDTO {

    private String id;
    private String identity;
    private String certificate;
    private boolean isValid;
    private LocalDateTime registeredAt;
    private LocalDateTime revokedAt;

}
