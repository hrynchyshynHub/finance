package com.hrnchshn.finance.subuz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JourneySubscriptionDto {
    private Long id;
    private StationDTO from;
    private StationDTO to;
    private String date;
    private String time;
    private String warningMessage;
    private boolean isActive;

    public JourneySubscription toEntity(){
        return JourneySubscription.builder()
                .date(date.substring(0, 10))
                .srcPlace(from.getValue())
                .srcTitle(from.getTitle())
                .time(time)
                .destPlace(to.getValue())
                .destTitle(to.getTitle())
                .isActive(isActive)
                .build();
    }
}
