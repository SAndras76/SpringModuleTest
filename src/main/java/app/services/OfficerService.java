package app.services;

import app.models.Officer;
import app.repositories.OfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OfficerService implements UserDetailsService {

    private OfficerRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public OfficerService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public OfficerService(OfficerRepo repo) {
        this.repo = repo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = repo.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Officer();
    }
    public void saveDefaultUser(){
        repo.save(new Officer("user", "user"));
    }

    public void saveUser (String username, String password) {
        String encodedPassword = encoder.encode(password);
    }
}
