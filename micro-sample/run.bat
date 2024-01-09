@echo off

:: SET JAVA HOME
set JAVA_HOME=C:\Program Files\Zulu\zulu-11
set payaramicro=C:\Program Files (x86)\Payara\payara-micro-5.2021.7.jar
set servicePort=8080
set projectBundle=target\micro-sample.war

set arg1=%1
set tests=%2
set testname=%3
set testmethod=%4

if "%arg1%"=="start" (
    call :start
)

if "%arg1%"=="build" (
  CALL :build
)

goto :eof

:start
@REM "%JAVA_HOME%\bin\java.exe" -jar "%payaramicro%" --deploy "%projectBundle%" --port "%servicePort%" 
"%JAVA_HOME%\bin\java.exe" -jar "%payaramicro%" --deploy "%projectBundle%" --port "%servicePort%" --autoBindHttp  --contextroot / --noCluster 
goto :eof
goto :eof

:build
call mvn clean package -DskipTests
goto :eof
