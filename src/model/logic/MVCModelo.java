package model.logic;

import java.io.FileReader;

import com.opencsv.CSVReader;

import model.data_structures.INode;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 */
public class MVCModelo{

	/**
	 * Atributos del modelo del mundo
	 */
	private MaxColaCP<TravelTime> colaDePrioridad;

	private MaxHeapCP<TravelTime> heapDePrioridad;
	
	private MaxHeapCP<TravelTime> generado;

	/**
	 * Constructor del modelo del mundo
	 */
	public MVCModelo()
	{
		colaDePrioridad = new MaxColaCP<>();
		heapDePrioridad = new MaxHeapCP<>(1);
		generado = new MaxHeapCP<>(1);
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

			if(!primeraLectura && contador < 1000000)
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

	public void generarMuestra(int n)
	{
		
	}
}