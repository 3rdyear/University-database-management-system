package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MenuBar menuBar = CreateMenu();
        root.getChildren().addAll(menuBar);
        primaryStage.setTitle("NIT MANIPUR");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        stage=primaryStage;
    }


    public static void main(String[] args) throws SQLException {

        Connection conn =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Keshav Mishra\\Desktop\\faculty.db");
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS teacher (name TEXT NOT NULL,department TEXT NOT NULL,gender TEXT NOT NULL,email TEXT NOT NULL,phone TEXT NOT NULL,id INTEGER PRIMARY KEY)");

        Connection conn1 =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Keshav Mishra\\Desktop\\student.db");
        Statement statement1 = conn1.createStatement();
        statement1.execute("CREATE TABLE IF NOT EXISTS info1 (name TEXT NOT NULL,year_of_admission INTEGER " +
                "NOT NULL,degree TEXT NOT NULL,branch TEXT NOT NULL,enroll INTEGER PRIMARY KEY,phone TEXT" +
                " NOT NULL,phone1 TEXT,e_mail TEXT NOT NULL,dob TEXT NOT NULL,gender TEXT NOT NULL)");

        Connection conn2 = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Keshav Mishra\\Desktop\\images.db");
        Statement statement2 = conn2.createStatement();
        statement2.execute("CREATE TABLE IF NOT EXISTS pics (id INTEGER references teacher(id),img TEXT NOT NULL )");
        launch(args);
    }
    private MenuBar CreateMenu(){
        Menu aboutmenu = new Menu("About");
        MenuItem nitmMenu = new MenuItem("NIT Manipur");
        nitmMenu.setOnAction(event -> {
            aboutnitmanipur();
        });
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem developerMenu = new MenuItem("Developer");
        developerMenu.setOnAction(event -> aboutdeveloper());
        aboutmenu.getItems().addAll(nitmMenu,separatorMenuItem,developerMenu);

        Menu administration = new Menu("ADMINISTRATION");
        MenuItem chairman = new MenuItem("Chairman");
        chairman.setOnAction(event -> aboutchairman());
        MenuItem director = new MenuItem("Director");
        director.setOnAction(event -> aboutdirector());
        MenuItem bogMember = new MenuItem("BOG Member");
        bogMember.setOnAction(event -> aboutbog());
        MenuItem hod = new MenuItem("Department's Head");
        hod.setOnAction(event -> abouthod());
        administration.getItems().addAll(chairman,director,bogMember,hod);

        Menu tnp = new Menu("TNP");
        MenuItem tnpnitm = new MenuItem("T&P");
        tnpnitm.setOnAction(event -> aboutTnp());
        tnp.getItems().addAll(tnpnitm);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(aboutmenu,administration,tnp);
        return menuBar;
    }

    private void aboutTnp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NITM Training & Placement Cell");
        alert.setHeaderText("Dr.KH.Johnson Singh\n" +
                "email id:johnkh34@gmail.com\n" +
                "Mobile: 7085223242\n" +
                "\n");
        alert.setContentText("The placement office handles all aspects of campus placements for the " +
                "graduating students at NIT Manipur. The office is well equipped with excellent " +
                "infra-structure to support every stage of the placement process. Arrangement for " +
                "Pre-Placement Talks, Interviews, Group Discussions etc. are all handled by the staff " +
                "at the office.");
        alert.show();
    }

    private void abouthod() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("DEPARTMENT HEAD");
        alert.setContentText("SR.No\tDepartments\tName\tDesignation\n" +
                "1.\tCivil Engineering\tDr. Tamphasana Devi\tAssistant Professor\n" +
                "2.\tComputer Science and Engineering\tDr. Y. Jina Chanu\tAssistant Professor\n" +
                "3.\tElectronics And Communication Engineering\tDr. L. Suraj Kumar Singh\tAssistant Professor\n" +
                "4.\tElectrical Engineering\tDr. Benjamin A Shimray\tAssistant Professor\n" +
                "5.\tMechanical Engineering\tDr. Dushyant Singh\tAssistant Professor\n" +
                "6.\tDepartment of Chemistry\tDr. Mithun Roy\tAssistant Professor\n" +
                "7.\tDepartment of Mathematics\tDr. Sanasam Surendra Singh\tAssistant Professor\n" +
                "8.\tDepartment of Physics\tDr. L. Herojit Singh\n" +
                "Assistant Professor\n" +
                "9.\tHumanities and Social Sciences\tDr. Sangeeta Laishram\tAssistant Professor ");
        alert.show();
    }

    private void aboutbog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("BOG Members");
        alert.setHeaderText("Board of Governors:");
        alert.setContentText("1.\tMr. Ashishkumar Chauhan\n" +
                "MD & CEO, Bombay Stock Exchange Ltd.,\n" +
                "Chairman\n" +
                "2.\tProf. (Dr.) Goutam Sutradhar\n" +
                "Director NIT Manipur, Ex-Officio\tMember\n" +
                "3.\tJoint Secretary \n" +
                "Technical Education, Depts. Higher Education MHRD\tMember\n" +
                "4.\tFinancial Adviser\n" +
                "Department of Higher Education MHRD\tMember\n" +
                "5.\tProf. Vardaraj Bapat, SJM School of Management, IIT Mumbai\n" +
                "Council Nominee\n" +
                "Member\n" +
                "6.\tDr. Okram Ratnabala Devi,  \n" +
                "Assoc. Prof. Mathematics, Manipur University, Council Nominee \n" +
                "Member\n" +
                "7.\tGovernment of Manipur Nominee.\n" +
                "Member\n" +
                "8.\tGovernment of Manipur Nominee.\n" +
                "Member\n" +
                "9.\t\n" +
                "Prof. Guru Prem Prasad M, Dean Academics Affairs, IIT Guwahati. \n" +
                "Nominated member of Director, IIT Guwahati.\n" +
                "\n" +
                "Member\n" +
                "10.\tDr. Mayengbam Sunil Singh, Asst. Prof.(Civil Engg. Dept.) NIT Manipur\n" +
                "Member\n" +
                "11.\tDr. Mithun Roy, Asst. Prof.(Chemistry) NIT Manipur\n" +
                "Member\n" +
                "12.\tRegistrar, NIT Manipur\tSecretary\t \n" +
                " \t ");
        alert.show();
    }

    private void aboutdirector() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Director's Profile");
        alert.setHeaderText("Dr.Goutam Sutradhar");
        alert.setContentText("Dr.Goutam Sutradhar passed Bachelor in Mechanical Engineering from Jalpaiguri" +
                " Government Engineering College in 1984 and subsequently he did his Masters Degree in " +
                "Mechanical Engineering (Specialization in Foundry Technology) from IIT Kharagpur 1986 " +
                "and PhD in Engineering from Birla Institute of Technology (BIT) Mesra, Ranchi.");
        alert.show();
    }

    private void aboutchairman() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chairman’s Profile");
        alert.setHeaderText("Mr. Ashishkumar Chauhan \n" +
                "  Chairman BoG NIT Manipur and MD & CEO, BSE");
        alert.setContentText("Shri Ashishkumar Chauhan is the MD & CEO of BSE (Bombay Stock Exchange), " +
                "the first stock exchange of Asia. He is one of the founders of India's National Stock " +
                "Exchange (\"NSE\") where he worked from 1992 to 2000. He is best known as the " +
                "father of modern financial derivatives in India due to his work at NSE.");
        alert.show();
    }

    private void aboutdeveloper() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Desktop App");
        alert.setHeaderText("Developed in JavaFx");
        alert.setContentText("I love coding and app developing");
        alert.show();
    }

    private void aboutnitmanipur() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NIT Manipur");
        alert.setHeaderText("WELCOME TO NIT MANIPUR");
        alert.setContentText("NIT Manipur started its first session " +
                "on 2nd August 2010 with only three branches of Engineering " +
                "namely - Electrical Engineering, Electronics & Communication " +
                "Engineering and Computer Science & Engineering at Government " +
                "Polytechnic, Takyelpat Campus. It is presently functioning in its " +
                "Permanent Campus at Langol, Imphal, with two more Engineering " +
                "Branches namely - Mechanical Engineering and Civil Engineering. " +
                "The institute has acquired 341.5 acres of land in lush green areas of Langol, Imphal.");
        alert.show();
    }
}
