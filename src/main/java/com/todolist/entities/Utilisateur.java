package com.todolist.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(name = "username", length = 20, nullable = false)
	private String userName;
	@Column(name = "password", length = 20, nullable = false)
	private String password;
	@Column(name = "activate")
	private boolean activate;
	@Column(name = "nom")
	private String nom;
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	@Column(name = "rolename")
	private String roleName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private Set<ListeTache> listetache = new HashSet<ListeTache>(0);

	@ManyToOne
	@JoinColumn(name = "role")
	private RoleUtilisateur roleutilisateur;

	public Integer getUserId() {
		return userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public RoleUtilisateur getRoleutilisateur() {
		return roleutilisateur;
	}

	public void setRoleutilisateur(RoleUtilisateur roleutilisateur) {
		this.roleutilisateur = roleutilisateur;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String userName, String password, boolean activate, byte[] photo, String nom, String roleName) {
		super();
		this.userName = userName;
		this.password = password;
		this.activate = activate;
		this.photo = photo;
		this.nom = nom;
		this.roleName = roleName;
	}

}
