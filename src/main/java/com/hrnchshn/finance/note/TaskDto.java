package com.hrnchshn.finance.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private Double cost;
    private Boolean reminderEnable;
}
