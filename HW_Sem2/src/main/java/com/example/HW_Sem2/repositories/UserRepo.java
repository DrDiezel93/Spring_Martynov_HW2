package com.example.HW_Sem2.repositories;

import com.example.HW_Sem2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
