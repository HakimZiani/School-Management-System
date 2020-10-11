package common;

public class Etudiant {
	public Etudiant(String Matricule,String FName,String LName,String DateN,String Add )
	{
		this.Matricule = Matricule;
		this.FName = FName;
		this.LName = LName ;
		this.DateN = DateN;
		this.Add = Add;
	}
	private String Matricule;
	public String getMatricule() {
		return Matricule;
	}
	public void setMatricule(String matricule) {
		Matricule = matricule;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getDateN() {
		return DateN;
	}
	public void setDateN(String dateN) {
		DateN = dateN;
	}
	public String getAdd() {
		return Add;
	}
	public void setAdd(String add) {
		Add = add;
	}
	private String FName;
	private String LName;
	private String DateN;
	private String Add;
}
