package mtech.prokect.demopostgressapp.services;


import lombok.extern.slf4j.Slf4j;
import mtech.prokect.demopostgressapp.Users;
import mtech.prokect.demopostgressapp.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Cacheable(value = "users",key = "#id")
    public Users getUserById(long id) {

        var user = userRepository.findById(id).get();
        System.out.println("retriving from DB");

        return user;
    }


    @CachePut(value = "users",key = "#id")
    public Users updateUserEmail(long id, String email) {
        var user = userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }


    @CacheEvict(value = "users",key = "#id")
    public boolean deleteUser(long id) {
        userRepository.deleteById(id);
        return true;
    }


}
