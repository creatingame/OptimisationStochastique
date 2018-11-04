package stochastique;

public abstract class Recuit {
	//Classe abstraite g�n�rale pour effectuer un Recuit simul�. 
	//Ici avec en sc�nario un Circuit et en data notre objet Donnee
	//Attention, on est ici sur de la minimisation
	//On g�n�re notre nouveau sc�nario en 2-opt
	protected double temperature;
	protected Object scenario;
	protected int iterations;
	protected double refroidissement;
	
	
	Object getScenario() {
		return this.scenario;
	}
	
	abstract Object genererNouveauScenario();
	
	abstract void setTemperatureInitiale();
	
	void majTemperature() {
		this.temperature*=this.refroidissement;
	}
		
	abstract void effectuerRecuit();
	

}

