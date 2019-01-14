package com.hrnchshn.finance.money;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@DiscriminatorValue("UAH")
public class Grivna extends Money {
}
