@echo off
javac -classpath %CLASSPATH%;c:\jg\gtge\golden_0_2_3.jar;. %1Main.java

rem ECHO Compile game source code (.java) into bytecode (.class)
rem ECHO Usage: Tutorial2_1 [game_source_code]
rem ECHO e.g: Tutorial2_1 Tutorial6.java
rem pause