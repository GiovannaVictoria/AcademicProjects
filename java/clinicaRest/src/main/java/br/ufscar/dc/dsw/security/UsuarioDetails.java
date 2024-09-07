package br.ufscar.dc.dsw.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;
 
@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails {
 
    private Usuario usuario;
     
    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return usuario.getPassword();
    }
 
    @Override
    public String getUsername() {
        return usuario.getUsername();
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
    
    public boolean isMedico() {
        return usuario instanceof Medico;
    }

    public boolean isPaciente() {
        return usuario instanceof Paciente;
    }

	public Usuario getUsuario() {
		return usuario;
	}
    
}