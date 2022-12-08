# Me

- SOLOARIJAONA Paul Ferdinah ETU001915

## Prérequis

- Installer javafx dans votre IDE || Mettre les .jar (dans le dossier lib) dans votre  
  variable d'environnement

## À propos

- Ce programme est conçue pour faire du "Streaming" de vidéo , de musique et d'image
- Constituer d'un serveur et d'un client ou de plusieurs client
- Le "Streaming" dans ce programme se fait sous la facon suivante :
  - Le client se connecte dans le serveur et les médias qui sont présent
    dans le repository du serveur sont tous envoyer au client et le client n'a plus qu'à
    choisir ce qu'il veut voir ou écouter
  - Le transfert des données du médias se font par byte[] mais la lecture du média ne commence que
    si 25% (peut etre modifier) des bytes total du média sont transférer pour éviter une erreur de lecture (surtout pour les vidéos) -> les métadatas des vidéos doivent être recue pour pouvoir
    lancer la vidéo or l'emplacement de ces métadatas ne sont pas fixes , même si pour la plupart
    des cas elles se trouvent dans les premières bytes[]
  - La lecture se fait automatiquement après que 25% des bytes[] totale sont arrivés au client
    et le média se lance mais tout au cours de son lancement , le transfert des données restant du média continue (comme lorqu'on regarde des vidéos en ligne sur Youtube , Facebook , etc ... )
    - Pour permettre au client de revisionner la video ou d'avancer ou de remettre en arrière la vidéo , les bytes[] du média visionner sont stocker dans un fichier
  - L'application n'est pas encore 100% opérationnel et certains bugs peuvent arriver , surtout au niveau des vidéos avec les différent encodage de vidéos qui ne sont pas encore pris en compte

## Indication

=> Le serveur doit être lancer avant le client
=> Si votre programme ne trouve pas les .class de javafx veuiller utiliser la méthode suivante
pour compiler et executer le programme :

=>Pour compiler

- javac --module-path "path/du/dossier/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media (fichier.java)

=> Pour executer

- java --module-path "path/du/dossier/lib/" --add-modules javafx.controls,javafx.fxml,javafx.media (fichier.class)

## Autre

- Pour mettre les .jar dans le classpath avec MacOS utiliser cette méthode
  export CLASSPATH=${CLASSPATH}:/path/absolue/du/dossier/lib/javafx.swing.jar
  javafx-swt.jar
  javafx.controls.jar
  javafx.graphics.jar
  javafx.base.jar
  javafx.fxml.jar
  javafx.media.jar
