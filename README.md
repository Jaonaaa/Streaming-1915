## Before starting

- set up all .jar file in the lib

## Setting classPath Mac

=> export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/SteamingApp/lib/jlayer-1.0.1.jar

## Other setting

export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/DepotGit\ Socket/Streaming-1915/lib/javafx.swing.jar
javafx-swt.jar
javafx.controls.jar
javafx.graphics.jar
javafx.base.jar
javafx.fxml.jar
javafx.media.jar

javac --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src/App.java

java --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src.App

## Remarque

Sous mac - Veuillez a bien située les .jar
