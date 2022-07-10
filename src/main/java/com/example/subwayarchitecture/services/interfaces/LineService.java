package com.example.subwayarchitecture.services.interfaces;

import java.util.List;

import com.example.subwayarchitecture.models.Line;

/**
 * Service interface that defined methods to fetch line related information.
 */
public interface LineService {
	/**
	 * Method which returns all subways lines in the network;
	 */
	public List<Line> getAllLines();
}
