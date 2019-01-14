package com.hrnchshn.finance.money;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.common.EntityBase;
import lombok.Data;

import javax.persistence.*;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
@Data
public abstract class Money extends EntityBase {
    private Double amount;
    private String description;

    private Boolean isIncoming;

    //Was already in use
    private Boolean isActive;

    @ManyToOne
    private AUser user;

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", isIncoming=" + isIncoming +
                ", isActive=" + isActive +
                '}';
    }
}
