import java.util.ArrayList;


public class Bibliothéque {
	public ArrayList<Adherent> ad;
	public ArrayList<Document> doc;
	public Bibliothéque() {
		super();
		ad = new ArrayList<Adherent>() ;
		doc = new ArrayList<Document>();
	}
	public void ajouter_Adherent(Adherent a){
		ad.add(a);
	}
	public void enlever_Adherent(Adherent a){
		ad.remove(a);
	}
	/*public void modifier_Adherent(Adherent a){
		for(int i=0;i<ad.size();i++)
		{
			if(ad.get(i).getCode_Ad()==a.getCode_Ad()){
				ad.set(i,a);
			}
		}
	}
	
	public Adherent rechercher_Adherent(int id){
		for(Adherent a  : ad){
			if(a.getCode_Ad()==id)
				return a;
		}	
		return null;
	}
	protected void finalize(){
		
	}
	@Override
	public String toString() {
		return "Bibliothéque [ad=" + ad + ", doc=" + doc + "]";
	}*/





}
