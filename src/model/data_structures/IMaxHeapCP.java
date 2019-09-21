package model.data_structures;

public interface IMaxHeapCP <T>
{
	/**
	 * Retorna el n�mero de elementos del heap
	 * @return el n�mero de elementos del heap
	 */
	public int darNumeroElementos();
	
	/**
	 * A�ade un elemento al heap
	 * @param item elemento a a�adir
	 */
	public void agregar(T item);
	
	/**
	 * Saca el maximo  elemento a�adido al heap
	 * @return el maximo elemento a�adido al heap
	 */
	public T sacarMax();
	
	/**
	 * Retorna el maximo  elemento a�adido al heap
	 * @return el maximo elemento a�adido al heap
	 */
	public T darMax();
	
	/**
	 * Retorna si esta vacio el arreglo
	 * @return true si el arreglo esta vacio
	 */
	public boolean estaVacia();
}