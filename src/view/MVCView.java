package view;

public class MVCView 
{
	/**
	 * Metodo constructor
	 */
	public MVCView()
	{}

	/**
	 * M�todo que imprime el men� por consola
	 */
	public void printMenu()
	{
		System.out.println("1. Cargar archivo");
		System.out.println("2. Generar una muestra aleatoria de tama�o dado de tiempos de viaje");
		System.out.println("3. Consultar una cantidad dada de tiempos de viajes promedio m�s largos en un rango definido de horas");
		System.out.println("4. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}
}