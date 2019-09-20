package model.data_structures;

public class MaxColaCP <T extends Comparable<T>> implements IMaxColaCP<T>
{
	private int numeroElementos;
	public  MaxColaCP() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int darNumeroElementos() {
		
		return numeroElementos;
	}

	@Override
	public void agregar(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T sacarMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T darMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estavacia() {
		// TODO Auto-generated method stub
		return false;
	}

}
