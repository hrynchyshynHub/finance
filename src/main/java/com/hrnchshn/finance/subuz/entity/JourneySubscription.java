package com.hrnchshn.finance.subuz.entity;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.common.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JourneySubscription extends EntityBase {
    private Long srcPlace;
    private Long destPlace;
    private String date;
    private String time;
    private String warningMessage;

    private boolean isActive = true;
    private int callAttempt;

    @ManyToOne
    private AUser user;

    public JourneySubscriptionDto toDto(){
        return JourneySubscriptionDto.builder()
                .id(id)
                .date(date)
                .time(time)
                .from(srcPlace)
                .to(destPlace)
                .isActive(isActive)
                .warningMessage(warningMessage)
                .build();
    }

    public void incrementCallAttempt(){
        this.callAttempt++;
    }
}
