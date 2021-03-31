package br.com.fcamara.config.security.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.fcamara.entity.UserEntity;

public class AuthenticatedUser implements UserDetails {
	
	private static final long serialVersionUID = 3872106557897140293L;
	private UserEntity user;
	
	public AuthenticatedUser(UserEntity user) {
		this.user = user;
	}

/*	Implementando ROLES para o usuário.
	  Talvez nem fosse preciso ter e provavelmente só será usada uma
*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority()))
						.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
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
		return user.isActive();
	}

}
