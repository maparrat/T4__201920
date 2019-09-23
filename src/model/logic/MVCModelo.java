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
			if(!primeraLectura && contador < 10000)
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

		MaxHeapCP<TravelTime> copia = (MaxHeapCP<TravelTime>) heapDePrioridad.clone();

		int i = 0;

		Comparable[] elementos;

		while(i < tamanoMuestra && copia.darNumeroElementos() - i > 0)
		{
			elementos = copia.darElementos();

			int posicion = (int) Math.floor(Math.random()*elementos.length);

			TravelTime porAgregar = (TravelTime) elementos[posicion];

			if(porAgregar != null)
			{
				muestra.agregar(porAgregar);
				elementos[posicion] = null;
				i++;
			}
		}
	}

	public MaxColaCP<TravelTime> crearMaxColaCP(int tamano, int hInicial, int hFinal)
	{
		MaxColaCP<TravelTime> respuesta = new MaxColaCP<>();

		MaxColaCP<TravelTime> copia = (MaxColaCP<TravelTime>) colaDePrioridad.clone();

		for (int i = 0; i < tamano && copia.darNumeroElementos() > 0; i++)
		{
			TravelTime max = copia.sacarMax();

			if(max.darHora() >= hInicial && max.darHora() <= hFinal)
			{
				respuesta.agregar(copia.sacarMax());
			}
		}
		System.out.println(respuesta.darMax().darHora());

		return respuesta;
	}

	public MaxHeapCP<TravelTime> crearMaxHeapCP(int tamano, int hInicial, int hFinal)
	{
		MaxHeapCP<TravelTime> respuesta = new MaxHeapCP<>(tamano);
		
		MaxHeapCP<TravelTime> copia = (MaxHeapCP<TravelTime>) heapDePrioridad.clone();	

		for (int i = 0; i < tamano && copia.darNumeroElementos() > 0; i++)
		{
			TravelTime max = copia.sacarMax();

			if(max.darHora() >= hInicial && max.darHora() <= hFinal)
			{
				respuesta.agregar(copia.sacarMax());
			}
		}

		return respuesta;
	}
}