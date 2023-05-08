package com.thales.dis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpotFloorManager {

	public List<SpotLineManager> generate(int numberOfSpotLines, Map<SpotType, Integer> numberSpotsByType) {
		 ArrayList<SpotLineManager> spotLines = new ArrayList<SpotLineManager>();
		 spotLines.add(new SpotLineManager());
		 return spotLines;
	}

}
