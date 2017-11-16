/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * La implementacion del alumno debe pasar este test experimental
 */

import java.util.*;

public class TestsCorreccion {

	// Comprueba experimentalmente el motodo resolverTodos
	public static void testResolverTodos() {
		EvaluacionExperimental eval = new EvaluacionExperimental ("Test de resolverTodos");
		eval.realizarCon("tests.txt");
	}


	public static void main(String[] args) {
		testResolverTodos();
	}

}
