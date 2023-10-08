# Rapport sur le Code - Application de Support Technique

**Nom du Programme :** Main.java

**Description :** Cette application Java est une interface graphique (GUI) qui permet aux utilisateurs de saisir des informations liées au support technique, telles que le service, le type de problème, l'urgence et la priorité. L'application effectue des validations pour garantir que les champs obligatoires sont remplis.

## Analyse du Code

### Importations
Le programme commence par importer les classes nécessaires pour la création de l'interface graphique (Swing) et la gestion des événements.

### Fonction `main`
La méthode `main` sert de point d'entrée du programme. Elle crée une fenêtre (JFrame) et instancie différents composants graphiques.

### Composants GUI
Plusieurs composants Swing sont créés, tels que des boutons (JButton), des étiquettes (JLabel), des champs de texte (JTextField), des zones de texte (JTextArea), des cases à cocher (JCheckBox), des boutons radio (JRadioButton), et une liste déroulante (JComboBox). Ces composants sont utilisés pour collecter des informations de l'utilisateur.

### Actions
Des écouteurs d'événements sont ajoutés aux composants pour gérer les actions de l'utilisateur. Par exemple, un ActionListener est ajouté au bouton "Send" pour effectuer des validations et afficher un message d'information si les données sont valides.

### Gestion des Priorités
Lorsque la case à cocher "Urgent" est cochée, les boutons radio pour sélectionner la priorité (Low, Medium, High) deviennent activés. Sinon, ils sont désactivés.

### Validation
Avant d'envoyer les données, le code effectue des vérifications pour s'assurer que les champs obligatoires ne sont pas vides. Si des champs obligatoires sont vides, un message d'erreur est affiché.

### Affichage du Résultat
Si les données sont valides, un message d'information est affiché à l'utilisateur, récapitulant les informations saisies.

### Disposition des Composants
Les composants GUI sont ajoutés au conteneur JFrame et positionnés à l'aide de dispositions nulles (null layout) et de la méthode `setBounds`. Cela permet un positionnement personnalisé des composants.

### Mise en Forme
Une police personnalisée ("Bachir", taille 12) est définie pour certains composants. Le JTextArea a la capacité de défilement activée.

## Conclusion
Ce code Java crée une interface utilisateur simple pour collecter des informations de support technique, effectue des validations de base et affiche un message de confirmation lorsque les données sont valides. Il peut servir de base pour développer une application plus avancée de gestion des demandes de support.
