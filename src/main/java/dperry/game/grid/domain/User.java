package dperry.game.grid.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private static final long serialVersionUID = -1939627207685092575L;
	
	protected String username;
	protected String password;
	protected boolean active = true;
	protected boolean admin = false;
	
	public User() {
		
	}
	
	public User( String username ) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}
}
