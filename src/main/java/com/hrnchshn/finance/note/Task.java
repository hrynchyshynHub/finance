package com.hrnchshn.finance.note;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.common.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Task extends EntityBase {
    private String name;
    private String description;
    private Double cost;
    private Boolean reminderEnable;

    @ManyToOne
    private AUser user;
}
