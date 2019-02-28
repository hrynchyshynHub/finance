package com.hrnchshn.finance.transaction;

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
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Transaction extends EntityBase {
    private Double value;
    private Boolean isIncoming;
    @ManyToOne
    private AUser user;
}
