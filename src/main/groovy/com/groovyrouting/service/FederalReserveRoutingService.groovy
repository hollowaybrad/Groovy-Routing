package com.groovyrouting.service

import com.groovyrouting.beans.RoutingInfo

class FederalReserveRoutingService implements RoutingService{

	//Defaults to current fed directory
	String routingLink = "http://www.fededirectory.frb.org/fpddir.txt"

	//Defaults to current format described at http://www.fededirectory.frb.org/format.cfm
	Integer numberStartIndex = 0
	Integer numberEndIndex = 9
	Integer nameStartIndex = 27
	Integer nameEndIndex = 63


	public List<RoutingInfo> getRoutingInfoList(){

		def routingInfoList = []

		new URL(routingLink).eachLine {

			RoutingInfo routingInfo = new RoutingInfo()
			routingInfo.number = it.substring(numberStartIndex,numberEndIndex)
			routingInfo.name = it.substring(nameStartIndex,nameEndIndex)

			routingInfoList.add(routingInfo)
		}

		return routingInfoList
	}

	public String getNameByRoutingNumber(String routingNumber){

		def name = "";

		println "Looking for routing number: ${routingNumber}"

		new URL(routingLink).eachLine {
			if(it.substring(numberStartIndex,numberEndIndex) == routingNumber)
				name = it.substring(nameStartIndex,nameEndIndex)
		}

		return name
	}

	public String getRoutingNubmerByName(String name){

		def number = "";

		println "Looking for bank name: ${name}"

		new URL(routingLink).eachLine {
			if(it.substring(nameStartIndex,nameEndIndex).contains(name))
				number = it.substring(numberStartIndex,numberEndIndex)
		}

		return number
	}

}


