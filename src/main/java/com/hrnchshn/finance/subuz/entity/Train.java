package com.hrnchshn.finance.subuz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    private String trainNumber;
    private String fromStation;
    private String departingDateTime;
    private String toStation;
    private String arrivalDateTime;
    private List<SitPlace> places = new ArrayList<>();
}
