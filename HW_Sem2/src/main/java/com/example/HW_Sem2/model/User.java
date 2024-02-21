package com.example.HW_Sem2.model;
import jdk.jshell.Snippet;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder userId(Long id){
            newUser.id = id;
            return this;
        }

        public Builder firstName(String firstName){
            newUser.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            newUser.lastName = lastName;
            return this;
        }

        public User build(){
            return newUser;
        }
    }
}
