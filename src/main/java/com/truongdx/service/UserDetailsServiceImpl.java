package com.truongdx.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.truongdx.domain.*;
import com.truongdx.repository.LeaderRepository;
import com.truongdx.repository.LecturerRepository;
import com.truongdx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private LeaderRepository leaderRepository;
    private LecturerRepository lecturerRepository;
    private StudentRepository studentRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Lecturer lecturer = lecturerRepository.findByUsername(username);
        Student student = studentRepository.findByUsername(username);
        Leader leader = leaderRepository.findByUsername(username);
        String usernameLogin = "", passwordLogin = "";
        if (lecturer == null && student == null && leader == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            if (student != null) {
                usernameLogin = lecturer.getUsername();
                passwordLogin = lecturer.getPassword();
            } else if(leader != null){
                usernameLogin = leader.getUsername();
                passwordLogin = leader.getPassword();
            } else if( leader != null){
                usernameLogin = student.getUsername();
                passwordLogin = student.getPassword();
            }
            else{
                throw new UsernameNotFoundException("User not found");
            }
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = new HashSet<>();
        roles.addAll(lecturer.getRoles());
        roles.addAll(student.getRoles());
        roles.addAll(leader.getRoles());
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(usernameLogin, passwordLogin,
                grantedAuthorities);
    }


    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public List<User> seach(String q) {
        return null;
    }

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public List<User> findByFaculty(String faculty) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
