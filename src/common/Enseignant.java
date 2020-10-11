package common;

public class Enseignant {

	
	
	public Enseignant(String matricule, String nom, String prenom) {
		this.Matricule = matricule;
		this.Nom = nom;
		this.Prenom = prenom;
	}

	public String getMatricule() {
		return Matricule;
	}
	public void setMatricule(String matricule) {
		Matricule = matricule;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	private String Matricule;
	private String Nom;
	private String Prenom;

	
}
