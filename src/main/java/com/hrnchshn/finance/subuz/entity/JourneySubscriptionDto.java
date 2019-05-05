package com.hrnchshn.finance.subuz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JourneySubscriptionDto {
    private Long id;
    private Long from;
    private Long to;
    private String date;
    private String time;
    private String warningMessage;
    private boolean isActive;

    public JourneySubscription toEntity(){
        return JourneySubscription.builder()
                .date(date)
                .srcPlace(from)
                .time(time)
                .destPlace(to)
                .isActive(isActive)
                .build();
    }
}
