
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TotoLotek {
	public static void main(String[] args) {
		int[] numeryUsera = new int[6];
		int[] numeryWygrane = new int[6];
		int iloscTrafien = 0;
		String numerWpisywany;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj 6 numer�w z przedzia�u 1-50.");
		
//	pytamy uzytkownika o podanie 6 liczb w zakresie 1-50. Wyjatki pojawiaja sie kiedy podaje ta sama
//	liczbe co podal wczesniej lub gdy podana liczba jest w zlym zakresie
		for (int i=0; i<numeryUsera.length; i++) {
			boolean poprawny = false;
			while (!poprawny) {
				try {
					System.out.print("Liczba " + (i+1) + ": ");
					numerWpisywany = sc.nextLine();
					numeryUsera[i] = Integer.parseInt(numerWpisywany);
					if (numeryUsera[i] > 50 || numeryUsera[i] < 0) {
						System.out.println("Poda�e� numer w z�ym zakresie. Wybierz numer z zakresu 1-50");
					} else if (i!=0) {
						poprawny = true;
						for (int j=0; j<i; j++) {
							if (numeryUsera[i-j-1] == numeryUsera[i]) {
								System.out.println("Podana liczba jest ju� wybrana! Wybierz inn�");
								poprawny = false;
							}
						}
					} else
						poprawny = true;
				} catch (NumberFormatException ex) {
					System.out.println("Podaj numer w zakresie 1-50");
				} catch (InputMismatchException ex) {
					System.out.println("Podaj numer w zakresie 1-50");
				}
			}
		}
		System.out.println("Wybra�e� numery: ");
		for (int each: numeryUsera) {
			System.out.print(each + " ");
		}
		System.out.println();
		
		for (int i=0; i<numeryWygrane.length; i++) {
			numeryWygrane[i] = (int) (Math.random() * 50 + 1);
			boolean poprawny = false;
			while (!poprawny) {
				poprawny = true;
				for (int j=0; j<i; j++) {
					if (numeryWygrane[i-j-1] == numeryWygrane[i]) {
						poprawny = false;
						numeryWygrane[i] = (int) (Math.random() * 50 + 1);
					}
				}
			}
		}
		
		System.out.println("Numery wylosowane: ");
		for (int each: numeryWygrane) {
			System.out.print(each + " ");
		}
		System.out.println();
		
		for (int i=0; i<numeryWygrane.length; i++) {
			for (int j=0; j<numeryUsera.length; j++) {
				if (numeryUsera[i] == numeryWygrane[j]) {
					iloscTrafien++;
				}
			}
		}
		
		if (iloscTrafien == 6) {
			System.out.println("Trafi�e� 6!!! Mog�e� wygra� miliony gdyby to by�a prawdzwa gra");
		} else {
			System.out.println("Liczba trafionych liczb: " + iloscTrafien);
		}
	}
}
