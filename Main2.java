package TP;

import java.util.*;
import implementador_TP.ColaConPrioridad;
import interfaces.ColaConPrioridadTDA;
import implementador_TP.Conjunto;
import interfaces.ConjuntoTDA;

public class Main {

	public static void main(String[] args) {
		int id; int cliente;										//O(1)
		ColaConPrioridadTDA cola = new ColaConPrioridad();			//O(1)
		cola.InicializarCola();										//O(1)
		ConjuntoTDA conjuntoEmpresa = new Conjunto();				//O(1)
		conjuntoEmpresa.InicializarConjunto();						//O(1)
		ConjuntoTDA conjuntoParticularCliente = new Conjunto();		//O(1)
		conjuntoParticularCliente.InicializarConjunto();			//O(1)
		ConjuntoTDA conjuntoParticularNoCliente = new Conjunto();	//O(1)
		conjuntoParticularNoCliente.InicializarConjunto();			//O(1)
		
		Scanner input = new Scanner(System.in);						//O(1)
		
		for(int ingresos = 0;ingresos < 15;ingresos++) {				//O(15) == O(1)
			System.out.println("Bienvenido/a al banco 9 de Oro!");		//O(1)
			try {
				System.out.println("Ingrese su ID (8 carácteres): ");	//O(1)
				id = input.nextInt();									//O(1)
				String id_s = Integer.toString(id);						//O(1)
				int long_id = id_s.length();							//O(1)
				if(long_id < 8|| long_id > 8) {							//O(1)
					System.out.println("Error. El ID debe contener 8 carácteres.\nIngrese su ID: "); //O(1)
					id = input.nextInt();															 //O(1)
				}
				System.out.println("Ingrese tipo de cliente:\n1.Particular no cliente\n2.Particular cliente\n3.Empresa"); //O(1)
				cliente = input.nextInt();																				  //O(1)
				if(cliente<1 || cliente>3) {																			  //O(1)
					System.out.println("Error. Ingrese tipo de cliente:\n1.Particular no cliente\n2.Particular cliente\n3.Empresa"); //O(1)
					cliente = input.nextInt();																						 //O(1)
				}		
				cola.AcolarPrioridad(id,cliente); 							 //O(1)
			} catch(InputMismatchException e) {								 //O(1)
				System.out.println("Error. Ingrese un valor válido de ID."); //O(1)
				ingresos--; 												 //O(1)
				input.next(); 												 //O(1)
			}
				

			}
	System.out.println("Orden de clientes por prioridad.");					//O(1)
	while(!cola.ColaVacia()) {												//O(15) == O(1)
		System.out.println(cola.Primero());									//O(1)
		if(cola.Prioridad() == 1) {											//O(1)
			if(!conjuntoParticularNoCliente.Pertenece(cola.Primero())) {	//O(1)
				conjuntoParticularNoCliente.Agregar(cola.Primero());		//O(1)
				} 
		} else if(cola.Prioridad() == 2) {									//O(1)
			if(!conjuntoParticularCliente.Pertenece(cola.Primero())) {		//O(1)
					conjuntoParticularCliente.Agregar(cola.Primero());		//O(1)
				}
		} else if(cola.Prioridad() == 3)  {									//O(1)
			if(!conjuntoEmpresa.Pertenece(cola.Primero())) {				//O(1)
				conjuntoEmpresa.Agregar(cola.Primero());					//O(1)
			} 
		}
		cola.Desacolar();													//O(1)
		
	}
	System.out.println("\nConjunto de clientes Empresas.");					//O(1)
	if(conjuntoEmpresa.ConjuntoVacio() == true) {							//O(1)
		System.out.println("No hay clientes del tipo empresa");				//O(1)
	}
	while(!conjuntoEmpresa.ConjuntoVacio()) {	//Sumatoria desde 0 hasta n1 de c1 + c2 + c3 = O(n1), donde n1 = cantidad de elementos en conjuntoParticularClientes
		int cliE = conjuntoEmpresa.Elegir();//O(1) --> c1
		System.out.println(cliE);		    //O(1) --> c2
		conjuntoEmpresa.Sacar(cliE);		//O(1) --> c3
			}	
	System.out.println("\nConjunto de particulares clientes.");				//O(1)
	if(conjuntoParticularCliente.ConjuntoVacio() == true) {					//O(1)
		System.out.println("No hay particulares clientes");					//O(1)
	}
	while(!conjuntoParticularCliente.ConjuntoVacio()) {		//Sumatoria desde 0 hasta n2 de c1 + c2 + c3 = O(n2), donde n2 = cantidad de elementos en conjuntoParticularClientes
		int cliPC = conjuntoParticularCliente.Elegir();	//O(1) --> c1
		System.out.println(cliPC);						//O(1) --> c2
		conjuntoParticularCliente.Sacar(cliPC);			//O(1) --> c3
	}
	System.out.println("\nConjunto de particulares no clientes.");			//O(1)
	if(conjuntoParticularNoCliente.ConjuntoVacio() == true) {				//O(1)
		System.out.println("No hay particulares no clientes");				//O(1)
	}
	while(!conjuntoParticularNoCliente.ConjuntoVacio()) {	//Sumatoria desde 0 hasta n3 de c1 + c2 + c3 = O(n3), donde n3 = cantidad de elementos en conjuntoParticularNoClientes
		int cliPNC = conjuntoParticularNoCliente.Elegir();//O(1) --> c1
		System.out.println(cliPNC);						  //O(1) --> c2
		conjuntoParticularNoCliente.Sacar(cliPNC);		  //O(1) --> c3
	}
	
	}
	}
//Costo del algoritmo = O(n) porque los terminos máximos cuando se suman todos los costos los terminos máximos son O(n1) + O(n2) + O(n3), que es lo mismo que decir O(n)