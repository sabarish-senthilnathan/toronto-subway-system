package com.example.subwayarchitecture.services;

import java.util.List;

import com.example.subwayarchitecture.helpers.SubwayHelper;
import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.services.interfaces.LineService;

/**
 * Service class that is used to fetch subway line related information.
 */
public class LineServiceImpl implements LineService {

	/**
	 * Method which returns all subways lines in the network;
	 */
	public List<Line> getAllLines() {
		return new SubwayHelper().getAllLines();
	}
}
