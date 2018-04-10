// Program PAŃSTWA I STOLICE UNII EUROPEJSKIEJ to projekt wykonany
// w technologii JavaFX na przedmiot Programowanie obiektowe aplikacji bazodanowych.
package europeanunioncountriesquiz;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Bartłomiej Czerny
 */
public class EuropeanUnionCountriesQuiz extends Application {

    private static Stage primaryStage;

    Pane root = new Pane();

    Button buttonStartQuiz = new Button("Rozpoczęcie testu");
    Button buttonLearning = new Button("Nauka");
    Button buttonAbout = new Button("O programie");
    Button buttonExit = new Button("Wyjście");
    
    Button buttonPlayAnthem = new Button();
    Button buttonStopAnthem = new Button();
    
    Button buttonPlayLearning = new Button();
    Button buttonPauseLearning = new Button();
    Button buttonStopLearning = new Button();
    
    Button buttonBack = new Button("Powrót do menu");

    MediaPlayer mediaPlayerEuropeanAnthem;
    MediaPlayer mediaPlayerLearning;
    MediaPlayer mediaPlayerChariotsOfFire;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Państwa i stolice Unii Europejskiej");

        Scene primaryScene = new Scene(root, 1000, 950);
        primaryScene.getStylesheets().add("Style.css");

        primaryStage.setScene(primaryScene);
        primaryStage.setResizable(false);

        Image icon = new Image("file:resources/images/icon.png");
        primaryStage.getIcons().add(icon);

        ShowText showText = new ShowText();
        showText.showText();

        ShowEuropeanFlag showEuropeanFlag = new ShowEuropeanFlag();
        showEuropeanFlag.showEuropeanFlag();

        ShowEuropeanCountries showEuropeanCountries = new ShowEuropeanCountries();
        showEuropeanCountries.showEuropeanCountries();

        PlayEuropeanAnthem playEuropeanAnthem = new PlayEuropeanAnthem();
        playEuropeanAnthem.playEuropeanAnthem();

        AddButtons addButtons = new AddButtons();
        addButtons.addButtons();
        
        ButtonBack buttonBack = new ButtonBack();
        buttonBack.buttonBack();

        StartQuiz startQuiz = new StartQuiz();
        startQuiz.startQuiz(primaryStage);
        
        Learning learning = new Learning();
        learning.learning(primaryStage);
        
        OpenAboutWindow openAboutWindow = new OpenAboutWindow();
        openAboutWindow.openAboutWindow();

        CloseApp closeApp = new CloseApp();
        closeApp.closeApp();
        

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class ShowText {

        private void showText() {
            Label labelMotto = new Label("\"Zjednoczona w różnorodności\"");
            labelMotto.setId("labelMotto");

            root.getChildren().add(labelMotto);
        }
    }

    private class AddButtons {

        private void addButtons() {
            buttonStartQuiz.setId("buttonStartQuiz");
            buttonLearning.setId("buttonLearning");
            buttonAbout.setId("buttonAbout");
            buttonExit.setId("buttonExit");
            
            buttonPlayAnthem.setId("buttonPlayAnthem");
            buttonStopAnthem.setId("buttonStopAnthem");
            
            buttonPlayLearning.setId("buttonPlayLearning");
            buttonPauseLearning.setId("buttonPauseLearning");
            buttonStopLearning.setId("buttonStopLearning");
            
            buttonBack.setId("buttonBack");

            
            root.getChildren().addAll(buttonStartQuiz, buttonLearning, buttonAbout, buttonExit, buttonPlayAnthem, buttonStopAnthem);
        }
    }

    private class ShowEuropeanFlag {

        private void showEuropeanFlag() {
            Image imageEuropeanFlag = new Image("file:resources/images/europeanFlag.gif");
            ImageView ivEuropeanFlag = new ImageView();
            ivEuropeanFlag.setId("ivEuropeanFlag");

            ivEuropeanFlag.setImage(imageEuropeanFlag);

            ivEuropeanFlag.setFitWidth(575);
            ivEuropeanFlag.setFitHeight(400);

            root.getChildren().add(ivEuropeanFlag);

        }
    }

    private class ShowEuropeanCountries {

        private void showEuropeanCountries() {
            Image imageEuropeanCountries = new Image("file:resources/images/europeanCountries.png");
            ImageView ivEuropeanCountries = new ImageView();
            ivEuropeanCountries.setId("ivEuropeanCountries");

            ivEuropeanCountries.setImage(imageEuropeanCountries);

            ivEuropeanCountries.setFitWidth(400);
            ivEuropeanCountries.setFitHeight(400);

            root.getChildren().add(ivEuropeanCountries);
        }
    }

    private class PlayEuropeanAnthem {

        private void playEuropeanAnthem() {
            File fileEuropeanAnthem = new File("resources/media/europeanAnthem.mp3");

            
            Media musicFileEuropeanAnthem = new Media(fileEuropeanAnthem.toURI().toString());

            mediaPlayerEuropeanAnthem = new MediaPlayer(musicFileEuropeanAnthem);
            mediaPlayerEuropeanAnthem.setAutoPlay(true);

            buttonPlayAnthem.setOnAction(event -> {
                mediaPlayerEuropeanAnthem.stop();
                mediaPlayerEuropeanAnthem.play();
            });

            buttonStopAnthem.setOnAction(event -> {
                mediaPlayerEuropeanAnthem.stop();
            });
        }
    }

    private class OpenAboutWindow {

        private void openAboutWindow() {
            buttonAbout.setOnAction(event -> {
                Pane paneAboutWindow = new Pane();
                paneAboutWindow.setId("paneAboutWindow");

                Scene sceneAboutWindow = new Scene(paneAboutWindow, 500, 430);
                sceneAboutWindow.getStylesheets().add("Style.css");

                Stage stageAboutWindow = new Stage();
                stageAboutWindow.setTitle("O programie");
                stageAboutWindow.setScene(sceneAboutWindow);
                stageAboutWindow.setResizable(false);

                Image icon = new Image("file:resources/images/icon.png");
                stageAboutWindow.getIcons().add(icon);

                Image imageIcon = new Image("file:resources/images/icon.png");
                ImageView ivIcon = new ImageView();
                ivIcon.setId("ivIcon");

                ivIcon.setImage(imageIcon);
                ivIcon.setFitWidth(490);
                ivIcon.setFitHeight(300);

                Label labelAppName = new Label("Państwa i stolice Unii Europejskiej");
                labelAppName.setId("labelAppName");

                Label labelVersion = new Label("Wersja: 1.0");
                labelVersion.setId("labelVersion");

                Label labelAuthor = new Label("Copyright © 2017 Bartłoniej Czerny");
                labelAuthor.setId("labelAuthor");

                paneAboutWindow.getChildren().addAll(ivIcon, labelAppName, labelVersion, labelAuthor);

                stageAboutWindow.show();

            });
        }
    }

    private class CloseApp {

        private void closeApp() {
            buttonExit.setOnAction(event -> {
                Platform.exit();
            });
        }
    }

    private class StartQuiz {
        
        int points = 0;
        
        private void startQuiz(Stage stage) {
            buttonStartQuiz.setOnAction(event -> {
                root.getChildren().clear();
                mediaPlayerEuropeanAnthem.stop();

                EuropeanUnionCountriesQuiz.primaryStage = stage;

                //EuropeanUnionCountriesQuiz app = new EuropeanUnionCountriesQuiz();
                //app.start(primaryStage);
                
                Label labelTaskContent = new Label("Na podstawie przedstawionej mapy\nodpowiedz jakie to państwo i gdzie\nznajduje się jego stolica.");
                labelTaskContent.setId("labelTaskContent");
                
                Label labelPoints = new Label();
                labelPoints.setId("labelPoints");
                labelPoints.setText("Punkty: " +points);
                
                //Zadanie 1.
                Image imageMalta = new Image("file:resources/images/Countries/Malta.png");
                ImageView ivMalta = new ImageView();
                ivMalta.setId("ivMalta");
                ivMalta.setImage(imageMalta);
                
                
                ivMalta.setFitWidth(300);
                ivMalta.setFitHeight(300);
                
                
                Button buttonTask1Answer1 = new Button("Malta, Valetta");
                buttonTask1Answer1.setId("buttonTask1Answer1");
                
                Button buttonTask1Answer2 = new Button("Włochy, Rzym");
                buttonTask1Answer2.setId("buttonTask1Answer2");
                
                Button buttonTask1Answer3 = new Button("Luksemburg, Luksemburg");
                buttonTask1Answer3.setId("buttonTask1Answer3");
                
                Button buttonTask1Answer4 = new Button("Litwa, Wilno");
                buttonTask1Answer4.setId("buttonTask1Answer4");
                
                root.getChildren().addAll(ivMalta, buttonTask1Answer1, buttonTask1Answer2, buttonTask1Answer3, buttonTask1Answer4);
                
                //Zadanie 2.
                buttonTask1Answer1.setOnAction(a -> {
                    points++;
                    labelPoints.setText("Punkty: " +points);
                    
                    root.getChildren().removeAll(ivMalta, buttonTask1Answer1, buttonTask1Answer2, buttonTask1Answer3, buttonTask1Answer4);
                
                    Image imageHungary = new Image("file:resources/images/Countries/Hungary.png");
                    ImageView ivHungary = new ImageView();
                    ivHungary.setId("ivHungary");
                    ivHungary.setImage(imageHungary);

                    ivHungary.setFitWidth(300);
                    ivHungary.setFitHeight(300);
                    
                    
                    Button buttonTask2Answer1 = new Button("Czechy, Praga");
                    buttonTask2Answer1.setId("buttonTask2Answer1");

                    Button buttonTask2Answer2 = new Button("Rumunia, Bukareszt");
                    buttonTask2Answer2.setId("buttonTask2Answer2");

                    Button buttonTask2Answer3 = new Button("Węgry, Budapeszt");
                    buttonTask2Answer3.setId("buttonTask2Answer3");

                    Button buttonTask2Answer4 = new Button("Słowenia, Lublana");
                    buttonTask2Answer4.setId("buttonTask2Answer4");
                    
                    
                    root.getChildren().addAll(ivHungary, buttonTask2Answer1, buttonTask2Answer2, buttonTask2Answer3, buttonTask2Answer4);
                    
                    //Zadanie 3.
                    buttonTask2Answer3.setOnAction(b -> {
                        points++;
                        labelPoints.setText("Punkty: " +points);
                        
                        root.getChildren().removeAll(ivHungary, buttonTask2Answer1, buttonTask2Answer2, buttonTask2Answer3, buttonTask2Answer4);

                        Image imagePoland = new Image("file:resources/images/Countries/Poland.png");
                        ImageView ivPoland = new ImageView();
                        ivPoland.setId("ivPoland");
                        ivPoland.setImage(imagePoland);

                        ivPoland.setFitWidth(300);
                        ivPoland.setFitHeight(300);

                        Button buttonTask3Answer1 = new Button("Polska, Warszawa");
                        buttonTask3Answer1.setId("buttonTask3Answer1");

                        Button buttonTask3Answer2 = new Button("Wielka Brytania, Londyn");
                        buttonTask3Answer2.setId("buttonTask3Answer2");

                        Button buttonTask3Answer3 = new Button("Łotwa, Ryga");
                        buttonTask3Answer3.setId("buttonTask3Answer3");

                        Button buttonTask3Answer4 = new Button("Finlandia, Helsinki");
                        buttonTask3Answer4.setId("buttonTask3Answer4");

                        root.getChildren().addAll(ivPoland, buttonTask3Answer1, buttonTask3Answer2, buttonTask3Answer3, buttonTask3Answer4);
                        
                        //Zadanie 4.
                        buttonTask3Answer1.setOnAction(c -> {
                            points++;
                            labelPoints.setText("Punkty: " +points);
                            
                            root.getChildren().removeAll(ivPoland, buttonTask3Answer1, buttonTask3Answer2, buttonTask3Answer3, buttonTask3Answer4);

                            Image imageFrance = new Image("file:resources/images/Countries/France.png");
                            ImageView ivFrance = new ImageView();
                            ivFrance.setId("ivFrance");
                            ivFrance.setImage(imageFrance);

                            ivFrance.setFitWidth(300);
                            ivFrance.setFitHeight(300);

                            Button buttonTask4Answer1 = new Button("Austria, Wiedeń");
                            buttonTask4Answer1.setId("buttonTask4Answer1");

                            Button buttonTask4Answer2 = new Button("Dania, Kopenhaga");
                            buttonTask4Answer2.setId("buttonTask4Answer2");

                            Button buttonTask4Answer3 = new Button("Grecja, Ateny");
                            buttonTask4Answer3.setId("buttonTask4Answer3");

                            Button buttonTask4Answer4 = new Button("Francja, Paryż");
                            buttonTask4Answer4.setId("buttonTask4Answer4");

                            root.getChildren().addAll(ivFrance, buttonTask4Answer1, buttonTask4Answer2, buttonTask4Answer3, buttonTask4Answer4);
                            
                            //Zadanie 5.
                            buttonTask4Answer4.setOnAction(d -> {
                                points++;
                                labelPoints.setText("Punkty: " +points);
                                
                                root.getChildren().removeAll(ivFrance, buttonTask4Answer1, buttonTask4Answer2, buttonTask4Answer3, buttonTask4Answer4);

                                Image imageCyprus = new Image("file:resources/images/Countries/Cyprus.png");
                                ImageView ivCyprus = new ImageView();
                                ivCyprus.setId("ivCyprus");
                                ivCyprus.setImage(imageCyprus);

                                ivCyprus.setFitWidth(300);
                                ivCyprus.setFitHeight(300);

                                Button buttonTask5Answer1 = new Button("Estonia, Tallinn");
                                buttonTask5Answer1.setId("buttonTask5Answer1");

                                Button buttonTask5Answer2 = new Button("Cypr, Nikozja");
                                buttonTask5Answer2.setId("buttonTask5Answer2");

                                Button buttonTask5Answer3 = new Button("Szwecja, Sztokholm");
                                buttonTask5Answer3.setId("buttonTask5Answer3");

                                Button buttonTask5Answer4 = new Button("Słowacja, Bratysława");
                                buttonTask5Answer4.setId("buttonTask5Answer4");

                                root.getChildren().addAll(ivCyprus, buttonTask5Answer1, buttonTask5Answer2, buttonTask5Answer3, buttonTask5Answer4);
                                
                                //Zadanie 6.
                                buttonTask5Answer2.setOnAction(e -> {
                                    points++;
                                    labelPoints.setText("Punkty: " +points);
                                    
                                    root.getChildren().removeAll(ivCyprus, buttonTask5Answer1, buttonTask5Answer2, buttonTask5Answer3, buttonTask5Answer4);

                                    Image imageCroatia = new Image("file:resources/images/Countries/Croatia.png");
                                    ImageView ivCroatia = new ImageView();
                                    ivCroatia.setId("ivCroatia");
                                    ivCroatia.setImage(imageCroatia);

                                    ivCroatia.setFitWidth(300);
                                    ivCroatia.setFitHeight(300);

                                    Button buttonTask6Answer1 = new Button("Hiszpania, Madryt");
                                    buttonTask6Answer1.setId("buttonTask6Answer1");

                                    Button buttonTask6Answer2 = new Button("Chorwacja, Zagrzeb");
                                    buttonTask6Answer2.setId("buttonTask6Answer2");

                                    Button buttonTask6Answer3 = new Button("Niemcy, Berlin");
                                    buttonTask6Answer3.setId("buttonTask6Answer3");

                                    Button buttonTask6Answer4 = new Button("Słowenia, Lublana");
                                    buttonTask6Answer4.setId("buttonTask6Answer4");

                                    root.getChildren().addAll(ivCroatia, buttonTask6Answer1, buttonTask6Answer2, buttonTask6Answer3, buttonTask6Answer4);
                                    
                                    //Zadanie 7.
                                    buttonTask6Answer2.setOnAction(f -> {
                                        points++;
                                        labelPoints.setText("Punkty: " +points);
                                        
                                        root.getChildren().removeAll(ivCroatia, buttonTask6Answer1, buttonTask6Answer2, buttonTask6Answer3, buttonTask6Answer4);

                                        Image imageIreland = new Image("file:resources/images/Countries/Ireland.png");
                                        ImageView ivIreland = new ImageView();
                                        ivIreland.setId("ivIreland");
                                        ivIreland.setImage(imageIreland);

                                        ivIreland.setFitWidth(200);
                                        ivIreland.setFitHeight(300);

                                        Button buttonTask7Answer1 = new Button("Portugalia, Lizbona");
                                        buttonTask7Answer1.setId("buttonTask7Answer1");

                                        Button buttonTask7Answer2 = new Button("Bułgaria, Sofia");
                                        buttonTask7Answer2.setId("buttonTask7Answer2");

                                        Button buttonTask7Answer3 = new Button("Irlandia, Dublin");
                                        buttonTask7Answer3.setId("buttonTask7Answer3");

                                        Button buttonTask7Answer4 = new Button("Belgia, Bruksela");
                                        buttonTask7Answer4.setId("buttonTask7Answer4");

                                        root.getChildren().addAll(ivIreland, buttonTask7Answer1, buttonTask7Answer2, buttonTask7Answer3, buttonTask7Answer4);
                                        
                                        //Zadanie 8.
                                        buttonTask7Answer3.setOnAction(g -> {
                                            points++;
                                            labelPoints.setText("Punkty: " +points);
                                            
                                            root.getChildren().removeAll(ivIreland, buttonTask7Answer1, buttonTask7Answer2, buttonTask7Answer3, buttonTask7Answer4);

                                            Image imageBulgaria = new Image("file:resources/images/Countries/Bulgaria.png");
                                            ImageView ivBulgaria = new ImageView();
                                            ivBulgaria.setId("ivBulgaria");
                                            ivBulgaria.setImage(imageBulgaria);

                                            ivBulgaria.setFitWidth(300);
                                            ivBulgaria.setFitHeight(300);

                                            Button buttonTask8Answer1 = new Button("Grecja, Ateny");
                                            buttonTask8Answer1.setId("buttonTask8Answer1");

                                            Button buttonTask8Answer2 = new Button("Bułgaria, Sofia");
                                            buttonTask8Answer2.setId("buttonTask8Answer2");

                                            Button buttonTask8Answer3 = new Button("Wielka Brytania, Londyn");
                                            buttonTask8Answer3.setId("buttonTask8Answer3");

                                            Button buttonTask8Answer4 = new Button("Holandia, Amsterdam");
                                            buttonTask8Answer4.setId("buttonTask8Answer4");

                                            root.getChildren().addAll(ivBulgaria, buttonTask8Answer1, buttonTask8Answer2, buttonTask8Answer3, buttonTask8Answer4);
                                            
                                            //Zadanie 9.
                                            buttonTask8Answer2.setOnAction(h -> {
                                                points++;
                                                labelPoints.setText("Punkty: " +points);
                                                
                                                root.getChildren().removeAll(ivBulgaria, buttonTask8Answer1, buttonTask8Answer2, buttonTask8Answer3, buttonTask8Answer4);

                                                Image imageSlovenia = new Image("file:resources/images/Countries/Slovenia.png");
                                                ImageView ivSlovenia = new ImageView();
                                                ivSlovenia.setId("ivSlovenia");
                                                ivSlovenia.setImage(imageSlovenia);

                                                ivSlovenia.setFitWidth(300);
                                                ivSlovenia.setFitHeight(300);

                                                Button buttonTask9Answer1 = new Button("Słowenia, Lublana");
                                                buttonTask9Answer1.setId("buttonTask9Answer1");

                                                Button buttonTask9Answer2 = new Button("Belgia, Bruksela");
                                                buttonTask9Answer2.setId("buttonTask9Answer2");

                                                Button buttonTask9Answer3 = new Button("Łotwa, Ryga");
                                                buttonTask9Answer3.setId("buttonTask9Answer3");

                                                Button buttonTask9Answer4 = new Button("Niemcy, Berlin");
                                                buttonTask9Answer4.setId("buttonTask9Answer4");

                                                root.getChildren().addAll(ivSlovenia, buttonTask9Answer1, buttonTask9Answer2, buttonTask9Answer3, buttonTask9Answer4);
                                                
                                                //Zadanie 10.
                                                buttonTask9Answer1.setOnAction(i -> {
                                                    points++;
                                                    labelPoints.setText("Punkty: " +points);
                                                    
                                                    root.getChildren().removeAll(ivSlovenia, buttonTask9Answer1, buttonTask9Answer2, buttonTask9Answer3, buttonTask9Answer4);

                                                    Image imageLuxembourg = new Image("file:resources/images/Countries/Luxembourg.png");
                                                    ImageView ivLuxembourg = new ImageView();
                                                    ivLuxembourg.setId("ivLuxembourg");
                                                    ivLuxembourg.setImage(imageLuxembourg);

                                                    ivLuxembourg.setFitWidth(200);
                                                    ivLuxembourg.setFitHeight(300);

                                                    Button buttonTask10Answer1 = new Button("Polska, Warszawa");
                                                    buttonTask10Answer1.setId("buttonTask10Answer1");

                                                    Button buttonTask10Answer2 = new Button("Grecja, Ateny");
                                                    buttonTask10Answer2.setId("buttonTask10Answer2");

                                                    Button buttonTask10Answer3 = new Button("Luksemburg, Luksemburg");
                                                    buttonTask10Answer3.setId("buttonTask10Answer3");

                                                    Button buttonTask10Answer4 = new Button("Czechy, Praga");
                                                    buttonTask10Answer4.setId("buttonTask10Answer4");

                                                    root.getChildren().addAll(ivLuxembourg, buttonTask10Answer1, buttonTask10Answer2, buttonTask10Answer3, buttonTask10Answer4);
                                                    
                                                    //Zadanie 11.
                                                    buttonTask10Answer3.setOnAction(j -> {
                                                        points++;
                                                        labelPoints.setText("Punkty: " +points);
                                                        
                                                        root.getChildren().removeAll(ivLuxembourg, buttonTask10Answer1, buttonTask10Answer2, buttonTask10Answer3, buttonTask10Answer4);

                                                        Image imageNederlands = new Image("file:resources/images/Countries/Nederlands.png");
                                                        ImageView ivNederlands = new ImageView();
                                                        ivNederlands.setId("ivNederlands");
                                                        ivNederlands.setImage(imageNederlands);

                                                        ivNederlands.setFitWidth(300);
                                                        ivNederlands.setFitHeight(300);

                                                        Button buttonTask11Answer1 = new Button("Francja, Paryż");
                                                        buttonTask11Answer1.setId("buttonTask11Answer1");

                                                        Button buttonTask11Answer2 = new Button("Holandia, Amsterdam");
                                                        buttonTask11Answer2.setId("buttonTask11Answer2");

                                                        Button buttonTask11Answer3 = new Button("Szwecja, Sztokholm");
                                                        buttonTask11Answer3.setId("buttonTask11Answer3");

                                                        Button buttonTask11Answer4 = new Button("Rumunia, Bukareszt");
                                                        buttonTask11Answer4.setId("buttonTask11Answer4");

                                                        root.getChildren().addAll(ivNederlands, buttonTask11Answer1, buttonTask11Answer2, buttonTask11Answer3, buttonTask11Answer4);
                                                        
                                                        //Zadanie 12.
                                                        buttonTask11Answer2.setOnAction(k -> {
                                                            points++;
                                                            labelPoints.setText("Punkty: " +points);
                                                            
                                                            root.getChildren().removeAll(ivNederlands, buttonTask11Answer1, buttonTask11Answer2, buttonTask11Answer3, buttonTask11Answer4);

                                                            Image imageBelgium = new Image("file:resources/images/Countries/Belgium.png");
                                                            ImageView ivBelgium = new ImageView();
                                                            ivBelgium.setId("ivBelgium");
                                                            ivBelgium.setImage(imageBelgium);

                                                            ivBelgium.setFitWidth(300);
                                                            ivBelgium.setFitHeight(300);

                                                            Button buttonTask12Answer1 = new Button("Litwa, Wilno");
                                                            buttonTask12Answer1.setId("buttonTask12Answer1");

                                                            Button buttonTask12Answer2 = new Button("Portugalia, Lizbona");
                                                            buttonTask12Answer2.setId("buttonTask12Answer2");

                                                            Button buttonTask12Answer3 = new Button("Węgry, Budapeszt");
                                                            buttonTask12Answer3.setId("buttonTask12Answer3");

                                                            Button buttonTask12Answer4 = new Button("Belgia, Bruksela");
                                                            buttonTask12Answer4.setId("buttonTask12Answer4");

                                                            root.getChildren().addAll(ivBelgium, buttonTask12Answer1, buttonTask12Answer2, buttonTask12Answer3, buttonTask12Answer4);
                                                            
                                                            //Zadanie 13.
                                                            buttonTask12Answer4.setOnAction(l -> {
                                                                points++;
                                                                labelPoints.setText("Punkty: " +points);
                                                                
                                                                root.getChildren().removeAll(ivBelgium, buttonTask12Answer1, buttonTask12Answer2, buttonTask12Answer3, buttonTask12Answer4);

                                                                Image imageRomania = new Image("file:resources/images/Countries/Romania.png");
                                                                ImageView ivRomania = new ImageView();
                                                                ivRomania.setId("ivRomania");
                                                                ivRomania.setImage(imageRomania);

                                                                ivRomania.setFitWidth(350);
                                                                ivRomania.setFitHeight(300);

                                                                Button buttonTask13Answer1 = new Button("Węgry, Budapeszt");
                                                                buttonTask13Answer1.setId("buttonTask13Answer1");

                                                                Button buttonTask13Answer2 = new Button("Rumunia, Bukareszt");
                                                                buttonTask13Answer2.setId("buttonTask13Answer2");

                                                                Button buttonTask13Answer3 = new Button("Bułgaria, Sofia");
                                                                buttonTask13Answer3.setId("buttonTask13Answer3");

                                                                Button buttonTask13Answer4 = new Button("Chorwacja, Zagrzeb");
                                                                buttonTask13Answer4.setId("buttonTask13Answer4");

                                                                root.getChildren().addAll(ivRomania, buttonTask13Answer1, buttonTask13Answer2, buttonTask13Answer3, buttonTask13Answer4);
                                                                
                                                                //Zadanie 14.
                                                                buttonTask13Answer2.setOnAction(m -> {
                                                                    points++;
                                                                    labelPoints.setText("Punkty: " +points);
                                                                    
                                                                    root.getChildren().removeAll(ivRomania, buttonTask13Answer1, buttonTask13Answer2, buttonTask13Answer3, buttonTask13Answer4);

                                                                    Image imageGermany = new Image("file:resources/images/Countries/Germany.png");
                                                                    ImageView ivGermany = new ImageView();
                                                                    ivGermany.setId("ivGermany");
                                                                    ivGermany.setImage(imageGermany);

                                                                    ivGermany.setFitWidth(300);
                                                                    ivGermany.setFitHeight(400);

                                                                    Button buttonTask14Answer1 = new Button("Włochy, Rzym");
                                                                    buttonTask14Answer1.setId("buttonTask14Answer1");

                                                                    Button buttonTask14Answer2 = new Button("Grecja, Ateny");
                                                                    buttonTask14Answer2.setId("buttonTask14Answer2");

                                                                    Button buttonTask14Answer3 = new Button("Wielka Brytania, Londyn");
                                                                    buttonTask14Answer3.setId("buttonTask14Answer3");

                                                                    Button buttonTask14Answer4 = new Button("Niemcy, Berlin");
                                                                    buttonTask14Answer4.setId("buttonTask14Answer4");

                                                                    root.getChildren().addAll(ivGermany, buttonTask14Answer1, buttonTask14Answer2, buttonTask14Answer3, buttonTask14Answer4);
                                                                    
                                                                    //Zadanie 15.
                                                                    buttonTask14Answer4.setOnAction(n -> {
                                                                        points++;
                                                                        labelPoints.setText("Punkty: " +points);
                                                                        
                                                                        root.getChildren().removeAll(ivGermany, buttonTask14Answer1, buttonTask14Answer2, buttonTask14Answer3, buttonTask14Answer4);

                                                                        Image imageSpain = new Image("file:resources/images/Countries/Spain.png");
                                                                        ImageView ivSpain = new ImageView();
                                                                        ivSpain.setId("ivSpain");
                                                                        ivSpain.setImage(imageSpain);

                                                                        ivSpain.setFitWidth(300);
                                                                        ivSpain.setFitHeight(300);

                                                                        Button buttonTask15Answer1 = new Button("Polska, Warszawa");
                                                                        buttonTask15Answer1.setId("buttonTask15Answer1");

                                                                        Button buttonTask15Answer2 = new Button("Estonia, Tallinn");
                                                                        buttonTask15Answer2.setId("buttonTask15Answer2");

                                                                        Button buttonTask15Answer3 = new Button("Francja, Paryż");
                                                                        buttonTask15Answer3.setId("buttonTask15Answer3");

                                                                        Button buttonTask15Answer4 = new Button("Hiszpania, Madryt");
                                                                        buttonTask15Answer4.setId("buttonTask15Answer4");

                                                                        root.getChildren().addAll(ivSpain, buttonTask15Answer1, buttonTask15Answer2, buttonTask15Answer3, buttonTask15Answer4);
                                                                        
                                                                        buttonTask15Answer4.setOnAction(o -> {
                                                                            points++;
                                                                            
                                                                            root.getChildren().removeAll(labelTaskContent, labelPoints, ivSpain, buttonTask15Answer1, buttonTask15Answer2, buttonTask15Answer3, buttonTask15Answer4);

                                                                            Label labelResult = new Label();
                                                                            labelResult.setId("labelResult");
                                                                           
                                                                            File fileChariotsOfFire = new File("resources/media/ChariotsOfFire.mp3");

                                                                            Media musicFileChariotsOfFire = new Media(fileChariotsOfFire.toURI().toString());
                                                                            
                                                                            mediaPlayerChariotsOfFire = new MediaPlayer(musicFileChariotsOfFire);
                                                                            
                                                                            Image imageMedal = new Image("file:resources/images/medal.gif");
                                                                            ImageView ivMedal = new ImageView();
                                                                            ivMedal.setId("ivMedal");

                                                                            ivMedal.setImage(imageMedal);

                                                                            ivMedal.setFitWidth(500);
                                                                            ivMedal.setFitHeight(750);
                                                                            
                                                                            
                                                                            Image imageTraining = new Image("file:resources/images/training.gif");
                                                                            ImageView ivTraining = new ImageView();
                                                                            ivTraining.setId("ivTraining");

                                                                            ivTraining.setImage(imageTraining);

                                                                            ivTraining.setFitWidth(600);
                                                                            ivTraining.setFitHeight(750);
            
                                                                            if (points >= 12) {
                                                                                labelResult.setText("Gratulacje!\nLiczba uzyskanych przez Ciebie punktów: " + points + " / 15.");
                                                                                mediaPlayerChariotsOfFire.setAutoPlay(true);
                                                                                root.getChildren().add(ivMedal);

                                                                            } else {
                                                                                labelResult.setText("Musisz więcej się nauczyć.\nLiczba uzyskanych przez Ciebie punktów: " + points + " / 15.");
                                                                                root.getChildren().add(ivTraining);
                                                                            }
                                                                                
                                                                            

                                                                            root.getChildren().add(labelResult);

                                                                        });

                                                                        buttonTask15Answer1.setOnAction(o -> {
                                                                            points--;
                                                                        });

                                                                        buttonTask15Answer2.setOnAction(o -> {
                                                                            points--;
                                                                        });

                                                                        buttonTask15Answer3.setOnAction(o -> {
                                                                            points--;
                                                                        });

                                                                    });

                                                                    buttonTask14Answer1.setOnAction(n -> {
                                                                        points--;
                                                                        labelPoints.setText("Punkty: " +points);
                                                                    });

                                                                    buttonTask14Answer2.setOnAction(n -> {
                                                                        points--;
                                                                        labelPoints.setText("Punkty: " +points);
                                                                    });

                                                                    buttonTask14Answer3.setOnAction(n -> {
                                                                        points--;
                                                                        labelPoints.setText("Punkty: " +points);
                                                                    });

                                                                });

                                                                buttonTask13Answer1.setOnAction(m -> {
                                                                    points--;
                                                                    labelPoints.setText("Punkty: " +points);
                                                                });

                                                                buttonTask13Answer3.setOnAction(m -> {
                                                                    points--;
                                                                    labelPoints.setText("Punkty: " +points);
                                                                });

                                                                buttonTask13Answer4.setOnAction(m -> {
                                                                    points--;
                                                                    labelPoints.setText("Punkty: " +points);
                                                                });

                                                            });

                                                            buttonTask12Answer1.setOnAction(l -> {
                                                                points--;
                                                                labelPoints.setText("Punkty: " +points);
                                                            });

                                                            buttonTask12Answer2.setOnAction(l -> {
                                                                points--;
                                                                labelPoints.setText("Punkty: " +points);
                                                            });

                                                            buttonTask12Answer3.setOnAction(l -> {
                                                                points--;
                                                                labelPoints.setText("Punkty: " +points);
                                                            });

                                                        });

                                                        buttonTask11Answer1.setOnAction(k -> {
                                                            points--;
                                                            labelPoints.setText("Punkty: " +points);
                                                        });

                                                        buttonTask11Answer3.setOnAction(k -> {
                                                            points--;
                                                            labelPoints.setText("Punkty: " +points);
                                                        });

                                                        buttonTask11Answer4.setOnAction(k -> {
                                                            points--;
                                                            labelPoints.setText("Punkty: " +points);
                                                        });

                                                    });

                                                    buttonTask10Answer1.setOnAction(j -> {
                                                        points--;
                                                        labelPoints.setText("Punkty: " +points);
                                                    });

                                                    buttonTask10Answer2.setOnAction(j -> {
                                                        points--;
                                                        labelPoints.setText("Punkty: " +points);
                                                    });

                                                    buttonTask10Answer4.setOnAction(j -> {
                                                        points--;
                                                        labelPoints.setText("Punkty: " +points);
                                                    });

                                                });

                                                buttonTask9Answer2.setOnAction(i -> {
                                                    points--;
                                                    labelPoints.setText("Punkty: " +points);
                                                });

                                                buttonTask9Answer3.setOnAction(i -> {
                                                    points--;
                                                    labelPoints.setText("Punkty: " +points);
                                                });

                                                buttonTask9Answer4.setOnAction(i -> {
                                                    points--;
                                                    labelPoints.setText("Punkty: " +points);
                                                });

                                            });

                                            buttonTask8Answer1.setOnAction(h -> {
                                                points--;
                                                labelPoints.setText("Punkty: " +points);
                                            });

                                            buttonTask8Answer3.setOnAction(h -> {
                                                points--;
                                                labelPoints.setText("Punkty: " +points);
                                            });

                                            buttonTask8Answer4.setOnAction(h -> {
                                                points--;
                                                labelPoints.setText("Punkty: " +points);
                                            });

                                        });

                                        buttonTask7Answer1.setOnAction(g -> {
                                            points--;
                                            labelPoints.setText("Punkty: " +points);
                                        });

                                        buttonTask7Answer2.setOnAction(g -> {
                                            points--;
                                            labelPoints.setText("Punkty: " +points);
                                        });

                                        buttonTask7Answer4.setOnAction(g -> {
                                            points--;
                                            labelPoints.setText("Punkty: " +points);
                                        });

                                    });

                                    buttonTask6Answer1.setOnAction(f -> {
                                        points--;
                                        labelPoints.setText("Punkty: " +points);
                                    });

                                    buttonTask6Answer3.setOnAction(f -> {
                                        points--;
                                        labelPoints.setText("Punkty: " +points);
                                    });

                                    buttonTask6Answer4.setOnAction(f -> {
                                        points--;
                                        labelPoints.setText("Punkty: " +points);
                                    });

                                });

                                buttonTask5Answer1.setOnAction(e -> {
                                    points--;
                                    labelPoints.setText("Punkty: " +points);
                                });

                                buttonTask5Answer3.setOnAction(e -> {
                                    points--;
                                });

                                buttonTask5Answer4.setOnAction(e -> {
                                    points--;
                                    labelPoints.setText("Punkty: " +points);
                                });

                            });
                            
                            buttonTask4Answer1.setOnAction(d -> {
                                points--;
                                labelPoints.setText("Punkty: " +points);
                            });

                            buttonTask4Answer2.setOnAction(d -> {
                                points--;
                                labelPoints.setText("Punkty: " +points);
                            });

                            buttonTask4Answer3.setOnAction(d -> {
                                points--;
                                labelPoints.setText("Punkty: " +points);
                            });
                            

                        });
                        
                        buttonTask3Answer2.setOnAction(c -> {
                            points--;
                            labelPoints.setText("Punkty: " +points);
                        });

                        buttonTask3Answer3.setOnAction(c -> {
                            points--;
                            labelPoints.setText("Punkty: " +points);
                        });

                        buttonTask3Answer4.setOnAction(c -> {
                            points--;
                            labelPoints.setText("Punkty: " +points);
                        });
                    });
                    
                    buttonTask2Answer1.setOnAction(b -> {
                        points--;
                        labelPoints.setText("Punkty: " +points);
                    });

                    buttonTask2Answer2.setOnAction(b -> {
                        points--;
                        labelPoints.setText("Punkty: " +points);
                    });

                    buttonTask2Answer4.setOnAction(b -> {
                        points--;
                        labelPoints.setText("Punkty: " +points);
                    });
                    
                });
                
                buttonTask1Answer2.setOnAction(a -> {
                    points--;
                    labelPoints.setText("Punkty: " +points);
                });
                
                buttonTask1Answer3.setOnAction(a -> {
                    points--;
                    labelPoints.setText("Punkty: " +points);
                });
                
                buttonTask1Answer4.setOnAction(a -> {
                    points--;
                    labelPoints.setText("Punkty: " +points);
                });
                
                root.getChildren().addAll(labelTaskContent, labelPoints, buttonBack);
                
            });
        }
    }
    
    private class Learning {
        
        private void learning(Stage stage) {
            buttonLearning.setOnAction(event -> {
                root.getChildren().clear();
                mediaPlayerEuropeanAnthem.stop();

                EuropeanUnionCountriesQuiz.primaryStage = stage;

                
                File fileLearning = new File("resources/media/europeanUnionLearning.mp4");

                Media mediaLearning = new Media(fileLearning.toURI().toString());
                mediaPlayerLearning = new MediaPlayer(mediaLearning);
                
                MediaView mediaViewLearning = new MediaView(mediaPlayerLearning);
                mediaViewLearning.setId("mediaViewLearning");
                mediaViewLearning.setFitWidth(950);
                
                
                buttonPlayLearning.setOnAction(e -> {
                    mediaPlayerLearning.play();
                });
                 buttonPauseLearning.setOnAction(e -> {
                    mediaPlayerLearning.pause();
                });
                buttonStopLearning.setOnAction(e -> {
                    mediaPlayerLearning.stop();
                });
                
                
                root.getChildren().addAll(mediaViewLearning, buttonPlayLearning, buttonPauseLearning, buttonStopLearning, buttonBack);
            });
        }
    }
    
    private class ButtonBack {

        private void buttonBack() {
            buttonBack.setOnAction(e -> {
                if (mediaPlayerLearning != null)
                    mediaPlayerLearning.stop();
       
                if (mediaPlayerChariotsOfFire != null)
                    mediaPlayerChariotsOfFire.stop();

                EuropeanUnionCountriesQuiz app = new EuropeanUnionCountriesQuiz();
                app.start(primaryStage);
            });
        }
    }

}
