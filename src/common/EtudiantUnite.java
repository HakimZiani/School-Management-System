package common;

public class EtudiantUnite {
	public EtudiantUnite(String matricule_etu, String code_unite, String note_CC, String note_TP, String note_examen) {
		Matricule_etu = matricule_etu;
		Code_unite = code_unite;
		Note_CC = note_CC;
		Note_TP = note_TP;
		Note_examen = note_examen;
	}
	public String getMatricule_etu() {
		return Matricule_etu;
	}
	public void setMatricule_etu(String matricule_etu) {
		Matricule_etu = matricule_etu;
	}
	public String getCode_unite() {
		return Code_unite;
	}
	public void setCode_unite(String code_unite) {
		Code_unite = code_unite;
	}
	public String getNote_CC() {
		return Note_CC;
	}
	public void setNote_CC(String note_CC) {
		Note_CC = note_CC;
	}
	public String getNote_TP() {
		return Note_TP;
	}
	public void setNote_TP(String note_TP) {
		Note_TP = note_TP;
	}
	public String getNote_examen() {
		return Note_examen;
	}
	public void setNote_examen(String note_examen) {
		Note_examen = note_examen;
	}
	private String Matricule_etu;
	private String Code_unite;
	private String Note_CC;
	private String Note_TP;
	private String Note_examen;
}
