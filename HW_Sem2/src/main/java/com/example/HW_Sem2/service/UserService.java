package com.example.HW_Sem2.service;
import com.example.HW_Sem2.aspect.TrackUserAction;
import com.example.HW_Sem2.model.User;
import com.example.HW_Sem2.repositories.UserRepo;
import com.example.HW_Sem2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log
public class UserService {
    private final UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }
    @TrackUserAction
    public User saveUser(User user){
        return userRepo.save(user);
    }
    @TrackUserAction
    public void deleteById(Long id){
        userRepo.deleteById(id);
    }

    public User findById(Long id) {
        return userRepo.getById(id);
    }
//    @TrackUserAction
//    public User update(User user) {
//        Optional<User> optionalUser = userRepo.findById(user.getId());
//        if (optionalUser.isPresent()) {
//            User user1 = optionalUser.get();
//            user1.setFirstName(user.getFirstName());
//            user1.setLastName(user.getLastName());
//           return userRepo.save(user1);
//        } else {
//            throw new IllegalArgumentException("Book not found with id: " + user.getId());
//        }
//    }

    @TrackUserAction
    public User update(User user) {
        Optional<User> optionalUser = userRepo.findById(user.getId());
        if (optionalUser.isPresent()) {
            User userTemp = optionalUser.get();
            return userRepo.save(new User.Builder().userId(user.getId()).firstName(user.getFirstName() != null ? user.getFirstName() : userTemp.getFirstName())
                    .lastName(user.getLastName() != null ? user.getLastName() : userTemp.getLastName()).build());
        } else {
            throw new IllegalArgumentException("Book not found with id: " + user.getId());
        }
    }
}
