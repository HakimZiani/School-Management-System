package common;

public class Unite {
	
	private String Code_Unite;
	public Unite(String code_Unite, String matricule_ens, String libelle, String nbr_heures) {
		
		Code_Unite = code_Unite;
		Matricule_ens = matricule_ens;
		Libelle = libelle;
		Nbr_heures = nbr_heures;
	}
	
	
	
	public String getCode_Unite() {
		return Code_Unite;
	}
	public void setCode_Unite(String code_Unite) {
		Code_Unite = code_Unite;
	}
	public String getMatricule_ens() {
		return Matricule_ens;
	}
	public void setMatricule_ens(String matricule_ens) {
		Matricule_ens = matricule_ens;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public String getNbr_heures() {
		return Nbr_heures;
	}
	public void setNbr_heures(String nbr_heures) {
		Nbr_heures = nbr_heures;
	}



	private String Matricule_ens;
	private String Libelle;
	private String Nbr_heures;
	
}
