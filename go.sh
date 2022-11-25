#javac -cp /Users/paul/Desktop/SteamingApp/lib/jlayer-1.0.1.jar src/main/Were.java
javac --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src/MultiMedia/*.java
javac --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src/main/Were.java
java --module-path "/Users/paul/Desktop/javafx-sdk-19/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media src.main.Were
#export CLASSPATH=${CLASSPATH}:/Users/paul/Desktop/SteamingApp/lib/jlayer-1.0.1.jar
