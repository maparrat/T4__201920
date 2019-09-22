package view;

public class MVCView 
{
	/**
	 * Metodo constructor
	 */
	public MVCView()
	{}

	/**
	 * Método que imprime el menú por consola
	 */
	public void printMenu()
	{
		System.out.println("1. Cargar archivo");
		System.out.println("2. Generar una muestra aleatoria de tamaño dado de tiempos de viaje");
		System.out.println("3. Consultar una cantidad dada de tiempos de viajes promedio más largos en un rango definido de horas");
		System.out.println("4. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}
}