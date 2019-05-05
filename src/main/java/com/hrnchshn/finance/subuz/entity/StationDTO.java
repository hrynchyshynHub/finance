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
public class StationDTO {
    private String title;
    private Long value;
}
