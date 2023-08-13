package ru.tripadvisor.tripsocial.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TripSocialError {
    private List<String> messages;
    private Date timestamp;

    public TripSocialError(String message) {
        this(List.of(message));
    }

       public TripSocialError(List<String> messages) {
        this.messages = new ArrayList<>(messages);
        this.timestamp = new Date();
    }
}
