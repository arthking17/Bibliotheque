import java.util.Date;

public class Journal {
	public Date date_parution;

	public Journal(Date date_parution) {
		super();
		this.date_parution = date_parution;
	}
	protected void finalize(){		
	}
	@Override
	public String toString() {
		return "Journal [date_parution=" + date_parution + "]";
	}
	

}
