package fr.iutvalence.rocketrychallenge;

import java.util.ArrayList;

public abstract class Donnees
{
	protected ArrayList listeMesures;
	
	public ArrayList getListeMesures()
	{
		return this.listeMesures;
	}
	
	public String toString()
	{
		String str = "";
		for (Object o : this.listeMesures)
			str += o + "\n";
		return str;
	}
}
