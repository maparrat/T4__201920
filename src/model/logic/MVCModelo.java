package model.logic;

import java.io.FileReader;

import com.opencsv.CSVReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

/**
 * Definicion del modelo del mundo
 */
public class MVCModelo{

	/**
	 * Atributos del modelo del mundo
	 */
	private MaxColaCP<TravelTime> colaDePrioridad;

	private MaxHeapCP<TravelTime> heapDePrioridad;

	private MaxHeapCP<TravelTime> muestra;

	/**
	 * Constructor del modelo del mundo
	 */
	public MVCModelo()
	{
		colaDePrioridad = new MaxColaCP<>();
		heapDePrioridad = new MaxHeapCP<>(1);
	}

	/**
	 * Metodo que carga los archivos
	 * @param prutaArchivo CSV
	 */
	public void cargarArchivoCSVHourly(int trimestre) throws Exception
	{
		boolean primeraLectura = true;

		CSVReader reader = new CSVReader(new FileReader("data/bogota-cadastral-2018-" + trimestre + "-All-HourlyAggregate.csv"));
		int contador = 0;
		for(String[] line: reader)
		{
			if(!primeraLectura && contador < 20000)
			{
				contador++;
				TravelTime dato = new TravelTime(trimestre, Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), Double.parseDouble(line[3]), Double.parseDouble(line[4]));
				colaDePrioridad.agregar(dato);
				heapDePrioridad.agregar(dato);
			}
			primeraLectura = false;
		}
		reader.close();
	}

	public int darTamano()
	{
		return colaDePrioridad.darNumeroElementos();
	}

	public void generarMuestra(int tamanoMuestra)
	{
		muestra = new MaxHeapCP<>(1);

		int i = 0;

		Comparable[] elementos = heapDePrioridad.darElementos();

		int[] repetidos = new int[tamanoMuestra];

		while(i < tamanoMuestra && heapDePrioridad.darNumeroElementos() - i > 0)
		{
			int posicion = (int) Math.floor(Math.random()*heapDePrioridad.darNumeroElementos());

			TravelTime porAgregar = (TravelTime) elementos[posicion];

			boolean yaSeAgrego = false;

			for (int j = 0; j < i && !yaSeAgrego; j++)
			{
				if(posicion == repetidos[j])
				{
					yaSeAgrego = true;
				}
			}

			if(porAgregar != null && !yaSeAgrego)
			{
				muestra.agregar(porAgregar);
				i++;
				repetidos[i] = posicion;
			}
		}
	}

	public MaxColaCP<TravelTime> crearMaxColaCP(int tamano, int hInicial, int hFinal)
	{
		MaxColaCP<TravelTime> respuesta = new MaxColaCP<>();

		int i = 0;
		
		while(i < tamano && colaDePrioridad.darNumeroElementos() > 0)
		{
			TravelTime max = colaDePrioridad.sacarMax();

			if(max.darHora() >= hInicial && max.darHora() <= hFinal)
			{
				respuesta.agregar(max);
				i++;
			}
		}
		
		return respuesta;
	}

	public MaxHeapCP<TravelTime> crearMaxHeapCP(int tamano, int hInicial, int hFinal)
	{
		MaxHeapCP<TravelTime> respuesta = new MaxHeapCP<>(tamano);

		int i = 0;
		
		while(i < tamano && heapDePrioridad.darNumeroElementos() > 0)
		{			
			TravelTime max = heapDePrioridad.sacarMax();

			if(max.darHora() >= hInicial && max.darHora() <= hFinal)
			{
				respuesta.agregar(max);
				i++;
			}
		}

		return respuesta;
	}	
}