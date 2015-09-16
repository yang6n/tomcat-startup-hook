# Tomcat Startup Hook

##Windows

1. Drop tomcat-startup-hook.jar into ${TOMCAT_HOME}/bin/
2. Add the following line in ${TOMCAT_HOME}/bin/catalina.bat

	```batch
	set CATALINA_OPTS="-DStartupHook=${YOUR_SCRIPT_WITH_FULL_PATH}"
	```

3. Replace `CLASSPATH` to:

	```batch
	set "CLASSPATH=%CLASSPATH%;%CATALINA_HOME%\bin\bootstrap.jar;%CATALINA_HOME%\bin\tomcat-startup-hook.jar;%CATALINA_HOME%\lib\annotations-api.jar;%CATALINA_HOME%\lib\catalina-ant.jar;%CATALINA_HOME%\lib\catalina-ha.jar;%CATALINA_HOME%\lib\catalina-tribes.jar;%CATALINA_HOME%\lib\catalina.jar;%CATALINA_HOME%\lib\ecj-4.4.2.jar;%CATALINA_HOME%\lib\el-api.jar;%CATALINA_HOME%\lib\jasper-el.jar;%CATALINA_HOME%\lib\jasper.jar;%CATALINA_HOME%\lib\jsp-api.jar;%CATALINA_HOME%\lib\servlet-api.jar;%CATALINA_HOME%\lib\tomcat-api.jar;%CATALINA_HOME%\lib\tomcat-coyote.jar;%CATALINA_HOME%\lib\tomcat-dbcp.jar;%CATALINA_HOME%\lib\tomcat-i18n-es.jar;%CATALINA_HOME%\lib\tomcat-i18n-fr.jar;%CATALINA_HOME%\lib\tomcat-i18n-ja.jar;%CATALINA_HOME%\lib\tomcat-jdbc.jar;%CATALINA_HOME%\lib\tomcat-util.jar;%CATALINA_HOME%\lib\tomcat7-websocket.jar;%CATALINA_HOME%\lib\websocket-api.jar"
	```

##Linux
1. Drop tomcat-startup-hook.jar into ${TOMCAT_HOME}/bin/
2. Add the following line in ${TOMCAT_HOME}/bin/catalina.sh

	```bash
	CATALINA_OPTS="-DStartupHook=/tmp/abs.sh"
	```

3. Replace `CLASSPATH` to:

	```bash
	CLASSPATH="$CLASSPATH:${CATALINA_HOME}\bin\bootstrap.jar:${CATALINA_HOME}\bin\tomcat-startup-hook.jar:${CATALINA_HOME}\lib\*.jar"
	```