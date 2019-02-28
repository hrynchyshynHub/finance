package com.hrnchshn.finance.auser;

import java.util.List;
import javax.persistence.*;

import com.hrnchshn.finance.common.EntityBase;
import com.hrnchshn.finance.note.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AUser extends EntityBase{

    private String nickname;
    private String fullName;
    private String username;
    private String password;
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    private Double monthIncoming;
    private Double dayOutgoings;

    @Override
    public String toString() {
        return "AUser{" +
                "nickname='" + nickname + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
