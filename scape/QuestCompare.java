package scape;

import scape.util.ArrayCompare;
import scape.util.FileReader;

import java.io.IOException;

public class QuestCompare {
	public static void main (String[] args) throws IOException {
		FileReader gerjan = new FileReader("\\scape\\gerjan.txt");
		FileReader jasper = new FileReader( "\\scape\\jasper.txt");

		ArrayCompare comparer =  new ArrayCompare(gerjan.getLines(), jasper.getLines());

		for(String quest: comparer.intersection()) {
			System.out.println(quest);
		}
	}
}
