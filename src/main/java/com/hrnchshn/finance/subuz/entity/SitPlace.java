package com.hrnchshn.finance.subuz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ivan.hrynchyshyn
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SitPlace {
    private String type; //title
    private Integer count; //places
}
