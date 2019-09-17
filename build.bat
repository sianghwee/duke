@ECHO OFF
cls
.\gradlew shadowJar && copy .\build\libs\duke-0.1.3.jar . && cls