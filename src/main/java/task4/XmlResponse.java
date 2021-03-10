package task4;

import lombok.*;
import org.w3c.dom.Document;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class XmlResponse {

    private Document xmlDocument;

    public static XmlResponse from(Document xmlDocument) {
        return XmlResponse.builder().xmlDocument(xmlDocument).build();
    }
}
