package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPage {
	
		
	PasswordVerfication verfication;
	Scene scene;
	Stage stage;
	HomePage homepage;
	
	
	//CONSTRUCTOR
	
		public LoginPage(Stage stage)
		{
			this.stage=stage;
		}
		
		
	
	public void prepareLoginScene()
	{			
		 
		  ///////////////
		 //Login Scene//
		///////////////	
		
		Label username = new Label (" CardNumber ");
		username.setStyle("-fx-background-color: yellow");
		Label password = new Label (" Password ");
		password.setStyle("-fx-background-color: yellow");
		Label msg = new Label("(Ignore Case Sensitivity)");
		Label modify1 = new Label ("\t\t\t");
		Label modify2 = new Label ("\t\t\t");
		TextField namefield = new TextField ();
		PasswordField pwfield = new PasswordField ();
		Button loginbutton = new Button (" Login ");
		loginbutton.setStyle("-fx-background-color: cyan");
		loginbutton.setFont(new Font("Arial Black",16));
		GridPane grid = new GridPane();
		grid.add(modify1, 0, 0);
		grid.add(modify2, 0, 1);
		grid.add(username, 2, 2);
		grid.add(password, 2, 3);
		grid.add(namefield, 3, 2);
		grid.add(pwfield, 3, 3);
		grid.add(msg, 3, 4);
		grid.add(loginbutton, 3, 5);
		scene = new Scene(grid,400,300);
		namefield.setMaxWidth(130);
		pwfield.setMaxWidth(130);
		loginbutton.setMaxWidth(200);
		grid.setHgap(0);
	    grid.setVgap(10);
		///////////////////////////////////////////////////////////////////////
		
		PasswordVerfication verfication = new PasswordVerfication();
		
		///////////////////////////////////////////////////////////////////////
		
		  ////////////////
		 //Login Button//
		////////////////
		
		loginbutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

			String EnteredName = namefield.getText();
			String EnteredPw = pwfield.getText();	
			
			if (verfication.nameAndPwChecker(EnteredName,EnteredPw))
			{
				stage.setScene(homepage.getScene());	
			}
			else 
			{
				Label incorrect = new Label("Incorrect");
				incorrect.setFont(new Font("Webdings",30));
				incorrect.setTextFill(Color.RED);	
				grid.add(incorrect, 3, 6);
			}			
			}});
		
		
		
	}
		public Scene getScene() {return this.scene;}
			
		
		public void setHomepage(HomePage homepage) {this.homepage = homepage;}
}
