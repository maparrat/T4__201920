package model.logic;

public class TravelTime
{
	//Defina una clase TravelTime comparable con los atributos int trimestre, int sourceid,
	//nt distid, int hod, double mean_travel_time, double
	//standard_deviation_travel_time. La prioridad estará dada por el atributo
	//mean_travel_time. Implemente el método compareTo asumiendo que el criterio de
	//comparación por mean_travel_time
	private int trimestre;
	private int sourceid;
	private int distid;
	private int hod;
	private double mean_travel_time;
	private double standard_derivation_travel_time;

	public int compareTo(TravelTime param)
	{
		if(mean_travel_time > param.mean_travel_time)
		{
			return 1;
		}
		else if(mean_travel_time <  param.mean_travel_time)
		{
			return -1;
		}
		else
		{
			return 0;
		}		
		
	}

}
