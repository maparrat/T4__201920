package model.data_structures;

public interface IMaxColaCP <T>
{
	/**
	 * Retorna el n�mero de elementos de la cola
	 * @return el n�mero de elementos de la cola
	 */
	public int darNumeroElementos();
	
	/**
	 * A�ade un elemento a la cola
	 * @param item elemento a a�adir
	 */
	public void agregar(T item);
	
	/**
	 * Saca el maximo  elemento a�adido a la cola
	 * @return el maximo elemento a�adido a la cola
	 */
	public T sacarMax();
	
	/**
	 * Retorna el maximo  elemento a�adido a la cola
	 * @return el maximo elemento a�adido a la cola
	 */
	public T darMax();
	
	/**
	 * Retorna si esta vacio el arreglo
	 * @return true si el arreglo esta vacio
	 */
	public boolean estaVacia();
}