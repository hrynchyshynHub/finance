package com.hrnchshn.finance.subuz.entity;

import com.hrnchshn.finance.common.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JourneySubscription extends EntityBase {
    private Long from;
    private Long to;
    private String date;
    private String time;
    private String warningMessage;
}
