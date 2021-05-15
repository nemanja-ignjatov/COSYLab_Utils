package payloads.tnta.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketSignature implements Serializable {

    private String jwsEncoded;
    private String messageJson;
    private String issuerId;
    private String functionality;
}
