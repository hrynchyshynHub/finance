package com.hrnchshn.finance.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
