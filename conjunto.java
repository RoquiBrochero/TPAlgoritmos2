package implementacion_local;

import TDA_local.conjunto_TDA;

public class conjunto implements conjunto_TDA {
	int [] a;   // O(1)
	int cant;	// O(1)

	@Override
	public void Agregar(int x) {
		if (!Pertenece(x)) { // O(1)
			a[cant] = x;	 // O(1)
			cant ++;		 // O(1)
		}

	}

	@Override
	public void Sacar(int x) {
		int i = 0; 			 // O(1)
		while(i<cant&&a[i]!=x) { // O(n) = cant * c1
			i++; //c1
		}
		if(i<cant) {  // O(1)
			a[i] = a[cant-1];// O(1)
			cant--;// O(1)
		}
	}

	@Override
	public int Elegir() {
		return a[cant-1];// O(1)
	}

	@Override
	public boolean Pertenece(int x) {
		int i = 0;			// O(1)
		while (i<cant && a[i] != x) { // O(n) = cant * c1
			i ++; //c1
		}
		return (i<cant); // O(1)
	}

	@Override
	public boolean ConjuntoVacio() {
		return (cant == 0); // O(1)
	}

	@Override
	public void InicializarConjunto() {
		a = new int[100]; // O(1)
		cant = 0; 		  // O(1)

	}


}
