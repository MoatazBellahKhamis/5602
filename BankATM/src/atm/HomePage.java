package atm;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Date;



	public class HomePage {
		Scene scene;
		Stage stage;
		LoginPage loginpage;
		Services services = new Services();
		Date date = new Date();
		
		int i,j,maximum;
		
		
	
	//CONSTRUCTOR
	public HomePage(Stage stage)
	{
		this.stage=stage;
	}
		public void prepareHomeScene()
	{
		
			
			
			
		  //////////
		 //SCENES//
		//////////	
		
		//HOMEPAGE Scene//	
		Label msg = new Label("\t\t\tChoose An Operation ..");
		msg.setFont(new Font("Vernada",16));
		Label history1= new Label("");
		Button balance = new Button(" Balance ");
		Button deposit = new Button(" Deposit ");
		Button withdraw = new Button("Withdraw");
		//Button history = new Button("  History ");
		Button next = new Button("\t\t\tNext");
		Button previous = new Button("\t\t  Previous");
		next.setFont(new Font("Arial Black",14));
		previous.setFont(new Font("Arial Black",14));	
		GridPane grid = new GridPane();
		grid.add(msg, 0, 0);
		grid.add(deposit, 0, 2);
		grid.add(withdraw, 0, 4);
		//grid.add(history, 0, 6);
		grid.add(balance, 0, 6);
		grid.add(previous, 0, 8);
		grid.add(next, 0, 10);	
		grid.add(history1, 1, 10);
		grid.setHgap(2);
	    grid.setVgap(11);
		next.setStyle("-fx-background-color: yellow");
		previous.setStyle("-fx-background-color: cyan");
		scene = new Scene(grid,400,300);
		
		/////////////////////////////////////////////////////
							
		//DEPOSIT SCENE//
		Label depositLabel = new Label ("Enter The amount here ");
		depositLabel.setFont(new Font("Arial Black",14));
		TextField depositField = new TextField();
		Button submit = new Button("Submit");
		Button previous2 = new Button("\t\t  Previous");
		previous2.setStyle("-fx-background-color: cyan");
		previous2.setFont(new Font("Arial Black",14));
		GridPane depositgrid = new GridPane();
		depositgrid.setHgap(0);
	    depositgrid.setVgap(30);
		depositgrid.add(depositLabel, 0, 1);
		depositgrid.add(depositField, 0, 2);
		depositgrid.add(submit, 0, 3);
		depositgrid.add(previous2, 0, 5);
		Scene depositPageScene = new Scene(depositgrid,400,300);
		
		//////////////////////////////////////////////////////
		
		//WITHDRAW SCENE//
		Label withdrawLabel = new Label ("Enter The amount here ");
		withdrawLabel.setFont(new Font("Arial Black",14));
		TextField withdrawField = new TextField();
		Button submitWithDraw = new Button("Submit");
		Button previous3 = new Button("\t\t  Previous");
		previous3.setStyle("-fx-background-color: cyan");
		previous3.setFont(new Font("Arial Black",14));
		GridPane withdrawgrid = new GridPane();
		withdrawgrid.setHgap(20);
		withdrawgrid.setVgap(30);
		withdrawgrid.add(withdrawLabel, 0, 1);
		withdrawgrid.add(withdrawField, 0, 2);
		withdrawgrid.add(submitWithDraw, 0, 3);
		withdrawgrid.add(previous3, 0, 5);
		Scene withdrawPageScene = new Scene(withdrawgrid,400,300);
		
		//////////////////////////////////////////////////////
				
		
		//BALANCE SCENE//
		Scene balanceScene;
		Label balancemsg = new Label("\tYour Currrent Balance is : ");
		balancemsg.setFont(new Font("Arial Black",18));
		Label currentbalance = new Label("");	
		//System.out.println(services.getCurrentBalance());
		currentbalance.setFont(new Font("Arial Black",30));
		Button balanceprevious = new Button ("\t\t  Previous");
		balanceprevious.setFont(new Font("Arial Black",14));
		balanceprevious.setStyle("-fx-background-color: cyan");
		GridPane gridbalance = new GridPane();		
		gridbalance.add(balancemsg, 0, 1);
		gridbalance.add(currentbalance, 0, 3);
		gridbalance.add(balanceprevious, 0, 5);		
		gridbalance.setHgap(0);
		gridbalance.setVgap(25);
	    balanceScene = new Scene(gridbalance,400,300);
	    
		//////////////////////////////////////////////////////////
	    
	    //ERROR MSG Scene//
	    Scene errorScene;
		Label error = new Label ("You Dont Have Enough Cash");
		error.setFont(new Font("Arial Black",20));
		error.setTextFill(Color.RED);	
		Button ok = new Button("\t\t  Previous");
		ok.setStyle("-fx-background-color: cyan");
		ok.setFont(new Font("Arial Black",14));
		GridPane errorgrid = new GridPane();
		errorgrid.add(error, 0, 1);
		errorgrid.add(ok, 0, 4);
		errorgrid.setHgap(0);
		errorgrid.setVgap(48);
		errorScene = new Scene (errorgrid,400,300);
		stage.setScene(errorScene);
		
	      //////////
		 //BUTTONS/
		//////////
	
		//Home PREVIOUS BUTTON//
			previous.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {		
			j=services.getJ();
			maximum=services.getMaximum();
			if(j==0)
			{	
				history1.setText(services.previous());
				history1.setFont(new Font("Webdings",12));
				history1.setTextFill(Color.RED);	
			//	System.out.println(services.previous());
				stage.setScene(loginpage.getScene());
			}
			else 
			{	
				history1.setText(services.previous());
				history1.setFont(new Font("Webdings",12));
				history1.setTextFill(Color.RED);	
				//System.out.println(services.previous()+"  Else");	
			}
						
			}});
			
			//next BUTTON//
			next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				j=services.getJ();
				maximum=services.getMaximum();
				if(j==maximum)
				{
					history1.setText(services.next());
					history1.setFont(new Font("Webdings",12));
					history1.setTextFill(Color.RED);	
				//	System.out.println(services.next());
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setContentText("THIS IS THE LAST TRANSACTION.....");
					//System.out.println(services.print().toString());
					//alert.setContentText(""+ services.print().toString());	
					alert.show();
				}
				else 
				{
				//	System.out.println(services.next()+"  Else");
					history1.setText(services.next());
					history1.setFont(new Font("Webdings",12));
					history1.setTextFill(Color.RED);	
					//stage.setScene(loginpage.getScene());		
				}
					
			}});
					
		//BALANCE PREVIOUS BUTTON//
			balanceprevious.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			stage.setScene(getScene());				
			}});
			
		//BALANCE BUTTON//
			balance.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			currentbalance.setText(""+services.getCurrentBalance());
			stage.setScene(balanceScene);
			}});
		
		//DEPOSIT BUTTON//
			deposit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {				
			stage.setScene(depositPageScene);
			}});
		
		//WITHDRAW BUTTON//
			withdraw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {				
			stage.setScene(withdrawPageScene);
			}});		
			
		//PREVIOUS2 "Deposite" BUTTON//
			previous2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {				
			stage.setScene(getScene());
			}});	
		
		//PREVIOUS3 "Withdraw" BUTTON//
			previous3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {				
			stage.setScene(getScene());		 
			}});
				
		//"Error msg" BUTTON//
			ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			stage.setScene(withdrawPageScene);
			}});

			
		//Submit Deposit Button//
			submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {			
				if (services.checkNumber(depositField.getText())) 
				{	
					services.depositCash(Double.parseDouble(depositField.getText()));
					services.add("You Deposited : "+depositField.getText()+" LE");
					currentbalance.setText(""+services.getCurrentBalance());
					//services.add(depositField.getText());
					stage.setScene(balanceScene);		
				}
				else
				{	Label error = new Label ("Not Valid !");
					error.setFont(new Font("Arial Black",26));
					error.setTextFill(Color.RED);	
					depositgrid.add(error, 3, 2);}	
			}});
		
			
		//Submit Withdraw Button/
			submitWithDraw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {	
				if(services.checkNumber(withdrawField.getText()))
				{
							if(services.withdrawCash(Double.parseDouble(withdrawField.getText())))
							{
							services.add("You Withdrawed : "+withdrawField.getText()+" LE");
							currentbalance.setText(""+services.getCurrentBalance());
							//services.add(depositField.getText());
							
							stage.setScene(balanceScene);		}
							else
							stage.setScene(errorScene);		
							

							}
			 
				else
				{
					Label error = new Label ("Not Valid !");
					error.setFont(new Font("Arial Black",26));
					error.setTextFill(Color.RED);	
					withdrawgrid.add(error, 1, 2);
					}
			}});														
		}

		  /////////////////////
		 //Setters & Getters//
		/////////////////////
		
		public Scene getScene() {return this.scene;}
		public void setLoginpage(LoginPage loginpage) {this.loginpage = loginpage;}		
			
			}

	
	






