package com.groovyrouting.test

import com.groovyrouting.service.FederalReserveRoutingService

//Initial test, Spock tests to follow

//Print out all Routing numbers and Names
List routingInfoList = new FederalReserveRoutingService().getRoutingInfoList()

routingInfoList.each {
	println "Routing number: " + it.number
	println "Routing name: " + it.name
	println ""
}

//Size of all info
println "Size is: " + routingInfoList.size()

//Print name by
println "Name is:" + new FederalReserveRoutingService().getNameByRoutingNumber("325280039")

println ""

println "Number is:" + new FederalReserveRoutingService().getRoutingNubmerByName("ALPS FEDERAL CREDIT UNION")

