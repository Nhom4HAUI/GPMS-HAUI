package com.truongdx.config;

import java.util.HashSet;

import com.truongdx.domain.Faculty;
import com.truongdx.domain.Lecturer;
import com.truongdx.domain.Role;
import com.truongdx.repository.FacultyRepository;
import com.truongdx.repository.LeaderRepository;
import com.truongdx.repository.LecturerRepository;
import com.truongdx.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	LeaderRepository leaderRepository;

	@Autowired
	FacultyRepository facultyRepository;

	@Autowired
	LecturerRepository lecturerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		//Create ROLE
		if (roleRepository.findByName("ROLE_ADMIN") == null){
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
		if (roleRepository.findByName("ROLE_LECTURER") == null){
			roleRepository.save(new Role("ROLE_LECTURER"));
		}
		if (roleRepository.findByName("ROLE_LEADER") == null){
			roleRepository.save(new Role("ROLE_LEADER"));
		}
		if (roleRepository.findByName("ROLE_GUEST") == null){
			roleRepository.save(new Role("ROLE_GUEST"));
		}

		//Create Faculty
		if(facultyRepository.findByFacultyId("CNTT") == null){
			facultyRepository.save(new Faculty("CNTT", "Công nghệ thông tin", 0));
		}

		//Create Faculty
		if(facultyRepository.findByFacultyId("KT") == null){
			facultyRepository.save(new Faculty("KT", "Kế toán", 0));
		}

		//Create lecture
        if(lecturerRepository.findByUsername("gv1") == null){
            Lecturer lecturer = new Lecturer();
            lecturer.setUsername("gv1");
            lecturer.setPassword(passwordEncoder.encode("1"));
            lecturer.setFirstName("Nguyen Van ");
            lecturer.setLastName("A ");
            lecturer.setDegree("T.S");
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_LECTURER"));
            lecturer.setRoles(roles);
            lecturerRepository.save(lecturer);
        }
        //Create lecture
        if(lecturerRepository.findByUsername("gv2") == null){
            Lecturer lecturer = new Lecturer();
            lecturer.setUsername("gv2");
            lecturer.setPassword(passwordEncoder.encode("1"));
            lecturer.setFirstName("Nguyen Van ");
            lecturer.setLastName("B ");
            lecturer.setDegree("ThS");
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_LECTURER"));
            lecturer.setRoles(roles);
            lecturerRepository.save(lecturer);
        }

	}
}
