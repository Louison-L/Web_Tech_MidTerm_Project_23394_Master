package model;

import javax.persistence.*;


@Entity
@Table(name = "table_utilisateur")
public class Utilisateur {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer userId;
	 	@Column(name = "email")
	    private String email;
	 	@Column(name = "password")
	    private String password;
	 	@Column(name = "role")
	    private String role;
	 	
	 	
		public Utilisateur() {
			super();
		}
		public Utilisateur(String email, String password, String role) {
			super();
			this.email = email;
			this.password = password;
			this.role = role;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	 	
	 	
		
	 	
	 	
	 	
	 	

}
