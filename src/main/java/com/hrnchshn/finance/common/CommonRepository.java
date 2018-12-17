package com.hrnchshn.finance.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends EntityBase> extends JpaRepository<E, Long> {
}
