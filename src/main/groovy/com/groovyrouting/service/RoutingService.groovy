package com.groovyrouting.service


interface RoutingService{

	/**
	 * Gets a full list of RoutingInfo object from information source
	 *
	 * @return List RoutingInfo
	 */
	List getRoutingInfoList()

	/**
	 * Gets a establishments name for the given routing number
	 *
	 * @param routingNumber
	 * @return String name
	 */
	String getNameByRoutingNumber(String routingNumber)

	/**
	 * Gets a establishments routing number for the given name
	 *
	 * @param name
	 * @return String routing number
	 */
	String getRoutingNubmerByName(String name)

}


