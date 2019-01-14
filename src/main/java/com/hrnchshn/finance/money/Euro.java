package com.hrnchshn.finance.money;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@DiscriminatorValue("EUR")
public class Euro extends Money {
}
