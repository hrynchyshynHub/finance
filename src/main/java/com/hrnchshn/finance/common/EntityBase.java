package com.hrnchshn.finance.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Timestamp created;
    @CreatedBy
    protected String createdBy;

    @PrePersist
    public void setCreatedDate(){
        setCreated(new Timestamp(System.currentTimeMillis()));
    }
}
