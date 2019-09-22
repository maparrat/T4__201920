package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Node;
import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	/**
	 * Hilo de ejecución del programa
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			view.printMenu();

			String in;
			in = lector.next();

			int option;
			try
			{
				option = Integer.parseInt(in);
			}
			catch(NumberFormatException e)
			{
				option = 0;
			}

			switch(option){
			case 1:

				int numeroTrimestre;
				try
				{
					System.out.println("--------- \nCargar archivo \nDar numero del trimestre: ");
					numeroTrimestre = lector.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Debe ingresar un valor numérico (1 o 2)\n---------");
					break;
				}

				if(numeroTrimestre == 1 || numeroTrimestre == 2)
				{
					try
					{
						modelo.cargarArchivoCSVHourly(numeroTrimestre);
						System.out.println("Archivo cargado");
						System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");
					}
					catch (Exception e)
					{
						e.printStackTrace();
						System.out.println("Se ha producido un error al cargar el archivo\n---------");
					}
				}
				else
				{
					System.out.println("Ingrese un valor válido (1 o 2)\n---------");	
				}
				break;

			case 2:

				int tamanoMuestra;				
				try
				{
					System.out.println("---------\nDar tamaño de la muestra: ");
					tamanoMuestra = lector.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Debe ingresar un valor numérico (1 o 2).\n---------");
					break;
				}

				if(tamanoMuestra < 0)
				{
					System.out.println("Ingrese un valor válido.\n---------");	
				}

				modelo.generarMuestra(tamanoMuestra);
				System.out.println("Muestra generada.\n---------");	
				break;

			case 3:

				int numeroViajesBuscados;
				int horaInicial;
				int horaFinal;
				try
				{
					System.out.println("--------- \nDar cantidad de viajes a buscar: ");
					numeroViajesBuscados = lector.nextInt();
					System.out.println("--------- \nDar hora inicial: ");
					horaInicial = lector.nextInt();
					System.out.println("--------- \nDar hora a final: ");
					horaFinal = lector.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Debe ingresar valores numéricos\n---------");
					break;
				}

				if(numeroViajesBuscados < 0 || horaInicial < 0 || horaFinal > 23 || horaInicial > horaFinal)
				{
					System.out.println("Debe ingresar valores válidos\n---------");
					break;
				}

				long startTime1 = System.currentTimeMillis();
				modelo.crearMaxColaCP(numeroViajesBuscados, horaInicial, horaFinal);
				long endTime1 = System.currentTimeMillis();
				long duration1 = endTime1 - startTime1;

				long startTime2 = System.currentTimeMillis();
				modelo.crearMaxHeapCP(numeroViajesBuscados, horaInicial, horaFinal);
				long endTime2 = System.currentTimeMillis();
				long duration2 = endTime2 - startTime2;

				System.out.println("Tiempo de ejecución - Cola: " + duration1 + " milisegundos");
				System.out.println("Tiempo de ejecución - Heap: " + duration2 + " milisegundos\n---------");

				break;

			case 4: 

				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 

				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}
	}	
}