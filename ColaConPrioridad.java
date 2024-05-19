package implementacion_local;

import TDA_local.Cola_con_prioridad_TDA;

public class ColaConPrioridad implements Cola_con_prioridad_TDA {
	class Elemento{ // O(1)
		int valor;  // O(1)
		int prioridad;//O(1)
	}
	
	Elemento[] elementos; // O(1)
	int indice;			  // O(1)
	
	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice; //Copiamos el valor del indice en la variable j // O(1)
		for(; j>0 && elementos[j-1].prioridad >= prioridad;j--){ //Esta iteracion nos sirve para mover todos // O(n) = j * c1
			elementos[j] = elementos[j-1];  // c1                //los elementos con prioridad mayor al nuevo
		}                                                        //elemento dado por el usuario hacia la derecha
		
		elementos[j] = new Elemento(); //Aca borramos el elemento de la posicion j 					// O(1)
		elementos[j].valor = x; //Copiamos el valor dado por el usuario en la posicion j			// O(1)
		elementos[j].prioridad = prioridad; //Copiamos la prioridad del elemento x en la posicion j // O(1)
		indice++; //Incrementamos el valor de indice en 1											// O(1)	

	}

	@Override
	public void Desacolar() {
		elementos[indice-1] = null; //Borramos el elemento de mayor prioridad, que es el que esta mas // O(1)
									//a la derecha
		indice --;																						// O(1)
	}

	@Override
	public int Primero() {
		return elementos[indice-1].valor; //Devuelve el valor de mayor prioridad  						// O(1)
	}

	@Override
	public int Prioridad() {
		return  elementos[indice-1].prioridad; //Devuele la prioridad del valor con mas prioridad       // O(1)
	}

	@Override
	public boolean ColaVacia() {
		return (indice==0); //Indica si la cola esta vacia o no, comparando el valor de la variable indice // O(1)
	}

	@Override
	public void InicializarCola() {
		indice = 0;//Inicializamos la variable indice // O(1)
		elementos = new Elemento[100]; //Creamos una nueva cola con 100 posiciones // O(1)

	}

}
