package payloads.tnta.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCreationRequest implements Serializable {

    private String messageJson;
    private String functionality;
    private TicketType ticketType;
    private String subjectId;

}
