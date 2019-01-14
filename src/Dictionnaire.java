
public class Dictionnaire {
	public String auteur;

	public Dictionnaire(String auteur) {
		super();
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return "Dictionnaire [auteur=" + auteur + "]";
	}
	public void finalize(){
		
	}


}
