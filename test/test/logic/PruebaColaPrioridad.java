package test.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.logic.TravelTime;

public class PruebaColaPrioridad 
{
	private MaxColaCP<TravelTime> cola;
	private MaxHeapCP<TravelTime> heap;
	private TravelTime a,b,c,d,e,f,g,h,i,j,k;

	public void desordenadoSetUp ()
	{
		cola = new MaxColaCP<TravelTime>();
		heap = new MaxHeapCP<TravelTime>(1);
		a = new TravelTime(1,1, 1, 1, 12, 1);
		b = new TravelTime(1,1, 1, 1, 55, 1);
		c = new TravelTime(1,1, 1, 1, 6, 1);
		d = new TravelTime(1,1, 1, 1, 8, 1);
		e = new TravelTime(1,1, 1, 1, 13, 1);
		f = new TravelTime(1,1, 1, 1, 9, 1);
		g = new TravelTime(1,1, 1, 1, 56, 1);
		h = new TravelTime(1,1, 1, 1, 4, 1);
		i = new TravelTime(1,1, 1, 1, 5, 1);
		j = new TravelTime(1,1, 1, 1, 11, 1);
		k = new TravelTime(1,1, 1, 1, 1, 1);

		cola.agregar(a);
		cola.agregar(b);
		cola.agregar(c);
		cola.agregar(d);
		cola.agregar(e);
		cola.agregar(f);
		cola.agregar(g);
		cola.agregar(h);
		cola.agregar(i);
		cola.agregar(j);
		cola.agregar(k);

		heap.agregar(a);
		heap.agregar(b);
		heap.agregar(c);
		heap.agregar(d);
		heap.agregar(e);
		heap.agregar(f);
		heap.agregar(g);
		heap.agregar(h);
		heap.agregar(i);
		heap.agregar(j);
		heap.agregar(k);
		heap.agregar(g);
	}
	
	public void ordenadoASetUp ()
	{
		a = new TravelTime(1,1, 1, 1, 1, 1);
		b = new TravelTime(1,1, 1, 1, 2, 1);
		c = new TravelTime(1,1, 1, 1, 3, 1);
		d = new TravelTime(1,1, 1, 1, 4, 1);
		e = new TravelTime(1,1, 1, 1, 5, 1);
		f = new TravelTime(1,1, 1, 1, 6, 1);

		cola = new MaxColaCP<TravelTime>();
		heap = new MaxHeapCP<TravelTime>(1);
		cola.agregar(a);
		cola.agregar(b);
		cola.agregar(c);
		cola.agregar(d);
		cola.agregar(e);
		cola.agregar(f);

		heap.agregar(a);
		heap.agregar(b);
		heap.agregar(c);
		heap.agregar(d);
		heap.agregar(e);
		heap.agregar(f);

	}
	
	public void ordenadoDSetUp ()
	{
		a = new TravelTime(1,1, 1, 1, 6, 1);
		b = new TravelTime(1,1, 1, 1, 5, 1);
		c = new TravelTime(1,1, 1, 1, 4, 1);
		d = new TravelTime(1,1, 1, 1, 3, 1);
		e = new TravelTime(1,1, 1, 1, 2, 1);
		f = new TravelTime(1,1, 1, 1, 1, 1);

		cola = new MaxColaCP<TravelTime>();
		heap = new MaxHeapCP<TravelTime>(1);

		cola.agregar(a);
		cola.agregar(b);
		cola.agregar(c);
		cola.agregar(d);
		cola.agregar(e);
		cola.agregar(f);

		heap.agregar(a);
		heap.agregar(b);
		heap.agregar(c);
		heap.agregar(d);
		heap.agregar(e);
		heap.agregar(f);

	}
	
	public void repetidoSetUp ()
	{
		a = new TravelTime(1,1, 1, 1, 1, 1);
		b = new TravelTime(1,1, 1, 1, 1, 1);
		c = new TravelTime(1,1, 1, 1, 3, 1);
		d = new TravelTime(1,1, 1, 1, 3, 1);
		e = new TravelTime(1,1, 1, 1, 2, 1);
		f = new TravelTime(1,1, 1, 1, 2, 1);

		cola = new MaxColaCP<TravelTime>();
		heap = new MaxHeapCP<TravelTime>(1);
		
		cola.agregar(a);
		cola.agregar(b);
		cola.agregar(c);
		cola.agregar(d);
		cola.agregar(e);
		cola.agregar(f);

		heap.agregar(a);
		heap.agregar(b);
		heap.agregar(c);
		heap.agregar(d);
		heap.agregar(e);
		heap.agregar(f);

	}
	
	@Test
	public void testDesordenado()
	{
		desordenadoSetUp();
		assertTrue(cola != null);
		assertTrue(heap!= null);
		assertTrue(cola.estaVacia() == false);
		assertTrue(heap.estaVacia() == false);
		assertEquals(g, cola.darMax());
		assertEquals(g, heap.darMax());
		cola.sacarMax();
		heap.sacarMax();
		assertEquals(b,cola.darMax());
		assertEquals(g,heap.darMax());

	}
	
	@Test
	public void testAsendente()
	{
		ordenadoASetUp();
		assertTrue(cola != null);
		assertTrue(heap!= null);
		assertTrue(cola.estaVacia() == false);
		assertTrue(heap.estaVacia() == false);
		assertEquals(f, cola.darMax());
		assertEquals(f, heap.darMax());
		cola.sacarMax();
		heap.sacarMax();
		assertEquals(e,cola.darMax());
		assertEquals(e,heap.darMax());

	}
	
	@Test
	public void testDesendente()
	{
		ordenadoDSetUp();
		assertTrue(cola != null);
		assertTrue(heap!= null);
		assertTrue(cola.estaVacia() == false);
		assertTrue(heap.estaVacia() == false);
		assertEquals(a, cola.darMax());
		assertEquals(a, heap.darMax());
		cola.sacarMax();
		heap.sacarMax();
		assertEquals(b,cola.darMax());
		assertEquals(b,heap.darMax());

	}
	
	@Test
	public void testRepetido()
	{
		repetidoSetUp();
		assertTrue(cola != null);
		assertTrue(heap!= null);
		assertTrue(cola.estaVacia() == false);
		assertTrue(heap.estaVacia() == false);
		assertEquals(c, cola.darMax());
		assertEquals(c, heap.darMax());
		cola.sacarMax();
		heap.sacarMax();
		assertEquals(d,cola.darMax());
		assertEquals(d,heap.darMax());
	}
}