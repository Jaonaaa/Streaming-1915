## Before starting 

- set up all .jar file in the lib 

## Setting claasPath Mac

=> export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/SteamingApp/lib/jlayer-1.0.1.jar

## Other setting

export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.swing.jar
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx-swt.jar
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.controls.jar
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.graphics.jar
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.base.jar 
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.fxml.jar
export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/JavaFx/Test/lib/javafx.media.jar

javac --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src/App.java

java --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src.App
