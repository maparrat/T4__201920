package model.data_structures;

public interface INode <T>
{	
	/**
	 * Asigna el dato del nodo por el que llega por parametro
	 * @param pDato Nuevo dato
	 */
	public void asignarDato(T pDato);
	
	/**
	 * Asigna el siguiente nodo por el que llega por parametro
	 * @param pSiguiente Nuevo siguiente nodo
	 */
	public void cambiarSiguiente(Node pSiguiente);

	/**
	 * Dar sigueiente nodo 
	 * @return el nodo siguente 
	 */
	public Node darSiguiente();
	
	/**
	 * Retorna el dato del nodo
	 * @return el dato del nodo
	 */
	public T darElemento();
}