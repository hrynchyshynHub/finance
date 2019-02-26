package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.common.CommonRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface AUserRepository extends CommonRepository<AUser> {
    AUser findByUsername(String username);
}
