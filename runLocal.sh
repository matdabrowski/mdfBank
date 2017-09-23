#!/bin/bash

runCommand=$1
singleModuleName=$2

if [[ -z  $runCommand  ]] ; then
	echo "usage: run.sh  start | stop | restart"
	echo "   or: run.sh  up | down | reload [moduleName]"
	exit 1
fi

runFirstModules=("mdfDiscovery")
modules=("mdfCoreSystem" "mdfCustomer" "mdfLoanAndDeposit" "mdfSecurity" "mdfTransfer" "mdfWebAppBackend")

VERSION='0.0.1-SNAPSHOT'

function run {
	local name=$1[@]
    local modulesArr=("${!name}")
	for module in ${modulesArr[@]}
	do
		echo "# Start module $module"
		cd ../$module
		./gradlew build
		mkdir -p ../mdfBank/build/$module
		cp build/libs/$module-$VERSION.jar ../mdfBank/build/$module/$module-$VERSION.jar
		cd ../mdfBank/build/$module
		java -jar $module-$VERSION.jar 2>&1 > /dev/null &
		echo $!>pid.pid
		cd ../../
	done
}

function stop {
	local name=$1[@]
    local modulesArr=("${!name}")
	for module in ${modulesArr[@]}
	do
		echo "# Stop module $module"
		local pid="$(cat build/$module/pid.pid)"
		kill $pid
	done
}

function downModule {
	local module=$1
	echo "# down module $module"
	local pid="$(cat build/$module/pid.pid)"
	kill $pid
}

function upModule {
	local module=$1
	echo "# up module $module"
	cd ../$module
	./gradlew build
	mkdir -p ../mdfBank/build/$module
	cp build/libs/$module-$VERSION.jar ../mdfBank/build/$module/$module-$VERSION.jar
	cd ../mdfBank/build/$module
	java -jar $module-$VERSION.jar 2>&1 > /dev/null &
	echo $!>pid.pid
	cd ../../
}

if [ "$runCommand" == "start" ] ; then
	echo "start"
	# run first
	run runFirstModules
	echo "# running first modules ... waiting 20 sec."
	sleep 20
	#run others
	run modules
fi

if [ "$runCommand" == "stop" ] ; then
	echo "# stop"
	stop modules
	stop runFirstModules
fi

if [ "$runCommand" == "restart" ] ; then
	echo "# stop"
	stop modules
	stop runFirstModules
	
	echo "start"
	# run first
	run runFirstModules
	echo "# running first modules ... waiting 20 sec."
	sleep 20
	#run others
	run modules
fi

if [ "$runCommand" == "down" ] ; then
	downModule $singleModuleName
fi

if [ "$runCommand" == "up" ] ; then
	upModule $singleModuleName
fi

if [ "$runCommand" == "reload" ] ; then
	downModule $singleModuleName
	upModule $singleModuleName
fi