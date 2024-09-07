package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity<Long> {
  
	@NotBlank
	@Column(nullable = false, length = 32, unique = true)
    private String username;
    
	@NotBlank
    @Column(nullable = false, length = 64)
    private String password;
       
    @NotBlank
    @Column(nullable = false, length = 64)
    private String name;
    
    @NotBlank
    @Column(nullable = false, length = 128)
    private String email;
    
    @NotBlank
    @Column(nullable = false, length = 16)
    private String role;
    
    @Column(nullable = false)
    private boolean enabled;

	public String getUsername() {
		return username;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}