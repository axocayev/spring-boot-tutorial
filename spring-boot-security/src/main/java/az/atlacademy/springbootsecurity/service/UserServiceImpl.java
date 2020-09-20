package az.atlacademy.springbootsecurity.service;

import az.atlacademy.springbootsecurity.entity.Role;
import az.atlacademy.springbootsecurity.entity.User;
import az.atlacademy.springbootsecurity.repositort.RoleRepository;
import az.atlacademy.springbootsecurity.repositort.UserRepository;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl  {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>((Collection<? extends Role>) roleRepository.findByName("USER")));
        userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findOne(long id) {
        return userRepository.getOne(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
