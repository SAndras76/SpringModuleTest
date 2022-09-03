package app.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Officer implements UserDetails {

    @Id
    @GeneratedValue
    private long id;
    private String username;

    private String password;

    private LocalDateTime workStart;

    private LocalDateTime workEnd;

    public Officer() {}

    public Officer(long id) {
        this.id = id;
    }

    public Officer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Officer(LocalDateTime workStart, LocalDateTime workEnd) {
        this();
        this.workStart = workStart;
        this.workEnd = workEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("USER");

        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        auths.add(auth);

        return auths;
    }

    public boolean isEnable() {
        return workEnd == null;
    }

    private GrantedAuthority createOneAuthority() {
        return new SimpleGrantedAuthority("ADMIN");
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDateTime workStart) {
        this.workStart = workStart;
    }

    public LocalDateTime getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(LocalDateTime workEnd) {
        this.workEnd = workEnd;
    }
}
