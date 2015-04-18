package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;

import edu.bsu.cs222.bot.Path;

public class Utility {
	
	public static List<Path> copyPaths(List<Path> list) {
		List<Path> copy = new ArrayList<Path>();
		for (Path path : list) {
			copy.add(path);
		}
		return copy;
	}

}
