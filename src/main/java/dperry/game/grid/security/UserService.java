package dperry.game.grid.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dperry.game.grid.domain.User;

public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
		return new User(username);
	}

}
