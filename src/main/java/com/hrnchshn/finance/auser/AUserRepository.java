package com.hrnchshn.finance.auser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AUserRepository extends JpaRepository<AUser, Long>{
}
