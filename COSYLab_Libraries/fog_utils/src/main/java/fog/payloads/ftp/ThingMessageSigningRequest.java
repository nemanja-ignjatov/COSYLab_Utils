package fog.payloads.ftp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThingMessageSigningRequest implements Serializable {

    private String generatedId;
    private String messageContent;
    private String functionality;
    private String messageHash;

    public ThingMessageSigningRequest(String generatedId, String messageContent, String functionality) {
        this.generatedId = generatedId;
        this.messageContent = messageContent;
        this.functionality = functionality;
    }
}
