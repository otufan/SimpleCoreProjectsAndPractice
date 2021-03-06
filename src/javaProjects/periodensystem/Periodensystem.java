package javaProjects.periodensystem;

import java.util.Arrays;

public class Periodensystem {

	static Element[] elementArray = new Element[118];

	public static void main(String[] args) {

		Periodensystem ps = new Periodensystem(); // eine Lokale Variable ist nötig, die Methode von der Klasse zu
													// erreichen

		Element e1 = new Element(); // 8 Element werden deklariert und dann die Werte zugewiesen. 1 mal mit der
									// ohneParameter Konst 7 mal mit den ParameterKons.

		e1.setAggregat(3);
		e1.setHauptgruppe(true);
		e1.setKernladungszahl(3);
		e1.setName("Wasserstoff");
		e1.setSymbol("H");
		e1.setSchale('K');

		Element e2 = new Element("He", "Helium", 2, 'K', 3, true);
		Element e3 = new Metall("Na", "Natrium", 11, 'M', 1, true, false, 21000000);
		Metall e4 = new Metall("Fe", "Eisen", 26, 'N', 1, false, false, 10020000);
		Element e5 = new Metall("Ge", "Germanium", 32, 'N', 1, false, true, 1.45);
		Element e6 = new Element("Br", "Brom", 35, 'N', 2, true);
		Element e7 = new Metall("Te", "Tellur", 52, 'O', 1, true, true, 0.005);
		Element e8 = new Metall("Au", "Gold", 79, 'P', 1, false, false, 44000000);

		elementArray[0] = e1;
		elementArray[1] = e2;
		elementArray[2] = e3;
		elementArray[3] = e4;
		elementArray[4] = e5;
		elementArray[5] = e6;
		elementArray[6] = e7;
		elementArray[7] = e8;

		System.out.println("************************** Periodensystem ****************************");
		
		System.out.println(Arrays.toString(elementArray));
		ausgabe(elementArray);
		
		System.out.println("\n\n***************** die Liste aller Metalle ***************** ");
		
		ausgabe(ps.getAllMetalls());
		

		System.out.println("\n*********** Informationen zum Element mit der Ordnungszahl 79  ************** ");
		System.out.println(ps.getElement(79)); // die Method zum Ordnungszahl 79 wird hier aufgerufen!

		System.out.println("\n*********** die Methode addElement(Element e); überprüfen  ************** \n");

		Element e9 = new Metall("Au", "Gold", 79, 'P', 1, false, false, 44000000);
		Element e10 = new Metall("Ts", "Test", 100, 'P', 1, false, false, 44000000);

		System.out.println("Einmal wird die Elemente versucht, einzufügen, die in der Liste schon drin ist\n");
		ps.addElement(e9); // Ausgabe : Dieses Element gibt es im Periodensystem!
		System.out.println("");
		System.out.println("Eine Test Elemente wird eingefügt, die in der Liste noch nicht drin ist\n");
		ps.addElement(e10);
		ausgabe(elementArray);
		

	}

	public void addElement(Element e) {

		int index = 0;

		if (hasElemenet(e.getKernladungszahl())) {
			System.out.println("********die Elemente mit der Kernladungszahl "+ e.getKernladungszahl()+"  gibt es im Periodensystem! ************");
		} else {

			for (int i = 0; i < elementArray.length; i++) {

				if (elementArray[i] != null) {
					index++;
				} else {
					break;
				}
			}

			elementArray[index] = e;
		}

	}

	public boolean hasElemenet(int oz) {

		boolean hasEle = false;

		int flag = 0;

		for (Element element : elementArray) {

			if (element != null) {
				if (element.getKernladungszahl() == oz) {
					flag++;
				}
			} else if (flag != 0) {
				hasEle = true;
			} else {
				hasEle = false;
			}
		}

		return hasEle;
	}

	public Element getElement(int oz) {

		Element e = null;

		if (hasElemenet(oz)) {

			for (Element element : elementArray) {
				if (element != null) {
					if (element.getKernladungszahl() == oz) {
						e = element;
					}
				}

			}
		}
		return e;
	}

	public Element[] getAllMetalls() {

		Element[] arr;
		int count = 0;

		for (Element element : elementArray) {
			if (element != null) {
				if (element.getClass().getSimpleName().equals("Metall")) {
					count++;
				}
			}
		}

		arr = new Element[count];
		count = 0;
		for (Element element : elementArray) {
			if (element != null) {
				if (element.getClass().getSimpleName().equals("Metall")) {
					arr[count] = element;
					count++;
				}
			}
		}

		return arr;
	}

	public static void ausgabe(Element [] elementArray) {

		for (Element element : elementArray) { // mit for-each kann jede elemente von array einfach erreicht werden

			if (element != null) { // überprüfen null <-- hier ist sehr wictig, um Exception zu vermeiden				
				
				System.out.println(element.toString());
			}

		}

	}

}
