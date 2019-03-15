package atm;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestATM extends Application  {
	Services s;
	
	public static void main(String[] args) {
		
		launch(args);
					
	}

	
	public void start(Stage primaryStage) throws Exception {
		LoginPage loginpage = new LoginPage(primaryStage);
		HomePage homepage = new HomePage(primaryStage);
		
		primaryStage.setTitle("Alex Bank");
		
		loginpage.prepareLoginScene();
		homepage.prepareHomeScene();
		
		primaryStage.setScene(loginpage.getScene());
		
		loginpage.setHomepage(homepage);
		homepage.setLoginpage(loginpage);
		
		primaryStage.show();
		
	}

}
