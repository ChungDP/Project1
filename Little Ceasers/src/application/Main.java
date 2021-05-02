package application;

import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	//Declearing Variables to be used globally
	private double counterCoke , counterSprite , counterOrange , counterRoot , counterTotal  , myNumber , total2;
	private TextField txtSize , txtToppings , txtDrinks;
	private int numChoices ;
	private double counter;
	private String small;
	private String toppings = "";
	private String drinks = "";
	public void start(Stage primaryStage) {
		try {
			//Creating the InterFace
			GridPane root = new GridPane();

			//Little Caesars Logo
			Label lblLogo = new Label();
			lblLogo.setGraphic(new ImageView(new Image("file:littlecaesarslogo.png"))); 
			lblLogo.setAlignment(Pos.CENTER);

			//These Lines of Code is the interface for selecting the size of pizza they want
			//This is the toggle group i will be using for the radio buttons
			ToggleGroup tglGroup = new ToggleGroup();

			//Creating the TextFields to display the prices
			txtSize = new TextField("$0.00");
			txtSize.setEditable(false);
			txtSize.setAlignment(Pos.CENTER);
			txtSize.setMaxSize(60, 10);
			txtSize.setStyle("-fx-background-color: white");

			txtToppings = new TextField("$0.00");
			txtToppings.setEditable(false);
			txtToppings.setAlignment(Pos.CENTER);
			txtToppings.setMaxSize(60, 10);
			txtToppings.setStyle("-fx-background-color: white");

			txtDrinks = new TextField("$0.00");
			txtDrinks.setEditable(false);
			txtDrinks.setAlignment(Pos.CENTER);
			txtDrinks.setMaxSize(60, 10);
			txtDrinks.setStyle("-fx-background-color: white");

			//These are the four sizes of pizza available
			//Small pizza
			RadioButton radSmall = new RadioButton("Small");
			radSmall.setToggleGroup(tglGroup);
			radSmall.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//Checks to see if the small button is clicked
					//if it is it prints out the price of a small pizza
					if(radSmall.isSelected());
					{
						myNumber = 7.99;
						DecimalFormat format = new DecimalFormat("0.00"); 
						txtSize.setText("$" +(format.format(myNumber)));
					}
				}
			});

			//Medium pizza
			RadioButton radMedium = new RadioButton("Medium");
			radMedium.setToggleGroup(tglGroup);
			radMedium.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//Checks to see if the medium button is clicked
					//if it is it prints out the price of a medium pizza
					if(radMedium.isSelected());
					{
						myNumber = 8.99;
						DecimalFormat format = new DecimalFormat("0.00"); 
						txtSize.setText("$" +(format.format(myNumber)));
					}
				}
			});

			//Large pizza	
			RadioButton radLarge = new RadioButton("Large");
			radLarge.setToggleGroup(tglGroup);
			radLarge.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//Checks to see if the large button is clicked
					//if it is it prints out the price of a large pizza
					if(radLarge.isSelected());
					{
						myNumber = 9.99;
						DecimalFormat format = new DecimalFormat("0.00"); 
						txtSize.setText("$" +(format.format(myNumber)));
					}
				}
			});

			//Party size
			RadioButton radParty = new RadioButton("Party");
			radParty.setToggleGroup(tglGroup);
			radParty.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//Checks to see if the party button is clicked
					//if it is it prints out the price of a party pizza
					if(radParty.isSelected());
					{
						myNumber = 10.99;
						DecimalFormat format = new DecimalFormat("0.00"); 
						txtSize.setText("$" +(format.format(myNumber)));
					}
				}
			});

			//This is where I store the radio buttons, in a VBox
			VBox vb = new VBox();
			vb.setPadding(new Insets(5, 30, 5, 0));
			vb.setSpacing(10);
			vb.getChildren().addAll(radSmall, radMedium, radLarge, radParty);

			//Then i put that Vbox in a tilepane to be sorted nicely
			TilePane tlePane = new TilePane();
			tlePane.setAlignment(Pos.CENTER_LEFT);
			tlePane.getChildren().addAll(vb);

			//Then i put that tilepane with the Vbox in it on top of this title pane
			TitledPane ttlPane = new TitledPane();
			ttlPane.setMaxSize(100, 50);
			ttlPane.setText("Size");
			ttlPane.setCollapsible(false);
			ttlPane.setContent(tlePane);

			//These lines of Code are for the toppings section
			//Creating the CheckBoxes
			//These are the CheckBoxes for all the Diffrent toppings, when they are selected i put it in a lamda method and the code
			//for the what happens starts at line 677 
			CheckBox chkMushrooms = new CheckBox("Mushrooms");
			chkMushrooms.setPrefSize(120, 30);
			chkMushrooms.setOnAction(e -> CheckBoxClicked(chkMushrooms));

			CheckBox chkPepperoni = new CheckBox("Pepperoni");
			chkPepperoni.setPrefSize(120, 30);
			chkPepperoni.setOnAction(e -> CheckBoxClicked(chkPepperoni));

			CheckBox chkPeppers = new CheckBox("Green Peppers");
			chkPeppers.setPrefSize(120, 30);
			chkPeppers.setOnAction(e -> CheckBoxClicked(chkPeppers));

			CheckBox chkBacon = new CheckBox("Bacon");
			chkBacon.setPrefSize(120, 30);
			chkBacon.setOnAction(e -> CheckBoxClicked(chkBacon));

			CheckBox chkOnions = new CheckBox("Onions");
			chkOnions.setPrefSize(120, 30);
			chkOnions.setOnAction(e -> CheckBoxClicked(chkOnions));

			CheckBox chkTomatoes = new CheckBox("Tomatoes");
			chkTomatoes.setPrefSize(120, 30);
			chkTomatoes.setOnAction(e -> CheckBoxClicked(chkTomatoes));

			CheckBox chkRedPprs = new CheckBox("Hot Peppers");
			chkRedPprs.setPrefSize(120, 30);
			chkRedPprs.setOnAction(e -> CheckBoxClicked(chkRedPprs));

			CheckBox chkExtraCheese = new CheckBox("Extra Cheese");
			chkExtraCheese.setPrefSize(120, 30);
			chkExtraCheese.setOnAction(e -> CheckBoxClicked(chkExtraCheese));

			//Same thing I did for the radio buttons, I put it all on a tile pane
			TilePane tilepane = new TilePane();
			tilepane.setPrefColumns(2);
			tilepane.setPadding(new Insets(5 , 0 , 5 , 0));
			tilepane.setAlignment(Pos.TOP_CENTER);
			tilepane.getChildren().addAll(chkMushrooms , chkPepperoni , chkPeppers , chkBacon ,
					chkOnions , chkTomatoes , chkRedPprs , chkExtraCheese);

			//Then i put it onto a title pane with the title of my choosing
			TitledPane root1 = new TitledPane();
			root1.setText("Toppings:");
			root1.setCollapsible(false);
			root1.setContent(tilepane);

			//This part of code is for the Beverage Section
			//This is where i create the label for each drink
			Label lblCoke = new Label();
			lblCoke.setText("Coke ");

			Label lblSprite = new Label();
			lblSprite.setText("Sprite ");

			Label lblOrange = new Label();
			lblOrange.setText("Orange ");

			Label lblRoot = new Label();
			lblRoot.setText("Root ");

			//Creating the ComboBoxes for each of the drinks
			ComboBox<String> cboCoke = new ComboBox<String>();
			cboCoke.getItems().addAll("0" , "1", "2", "3", "4", "5" , "6");
			cboCoke.setPrefWidth(20);
			cboCoke.setPromptText("0");
			cboCoke.setVisibleRowCount(6);
			cboCoke.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//For this part I got the value of what amount the user selects and converted it from a string to a number
					//then i multiply whatever value is selected by the cost of a drink (0.99) and store it in the variable counterCoke
					//then i do the same to the other comboboxes and i add up all the values of each combobox
					double value = Double.parseDouble(cboCoke.getValue());
					counterCoke = value * 0.99;
					counterTotal = counterCoke + counterSprite + counterOrange + counterRoot;
					DecimalFormat format = new DecimalFormat("0.00"); 
					txtDrinks.setText("$" +(format.format(counterTotal)));
				}
			});

			ComboBox<String> cboSprite = new ComboBox<String>();
			cboSprite.getItems().addAll("0" , "1", "2", "3", "4", "5" , "6");
			cboSprite.setPrefWidth(20);
			cboSprite.setPromptText("0");
			cboSprite.setVisibleRowCount(6);
			cboSprite.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//I do the same thing for all the comboboxes
					double value1 = Double.parseDouble(cboSprite.getValue());
					counterSprite = value1 * 0.99;
					counterTotal = counterCoke + counterSprite + counterOrange + counterRoot;
					DecimalFormat format = new DecimalFormat("0.00"); 
					txtDrinks.setText("$" +(format.format(counterTotal)));
				}
			});

			ComboBox<String> cboOrange = new ComboBox<String>();
			cboOrange.getItems().addAll("0" , "1", "2", "3", "4", "5" , "6");
			cboOrange.setPrefWidth(20);
			cboOrange.setPromptText("0");
			cboOrange.setVisibleRowCount(6);
			cboOrange.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//I do the same thing for all the comboboxes
					double value2 = Double.parseDouble(cboOrange.getValue());
					counterOrange = value2 * 0.99;
					counterTotal = counterCoke + counterSprite + counterOrange + counterRoot;
					DecimalFormat format = new DecimalFormat("0.00"); 
					txtDrinks.setText("$" +(format.format(counterTotal)));
				}
			});

			ComboBox<String> cboRoot = new ComboBox<String>();
			cboRoot.getItems().addAll("0" , "1", "2", "3", "4", "5" , "6");
			cboRoot.setPrefWidth(20);
			cboRoot.setPromptText("0");
			cboRoot.setVisibleRowCount(6);
			cboRoot.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//I do the same thing for all the comboboxes
					double value3 = Double.parseDouble(cboRoot.getValue());
					counterRoot = value3 * 0.99;
					counterTotal = counterCoke + counterSprite + counterOrange + counterRoot;
					DecimalFormat format = new DecimalFormat("0.00"); 
					txtDrinks.setText("$" +(format.format(counterTotal)));
				}
			});

			//Just like the sizes and the toppings I add all the combo boxes for the drinks into a Vbox so its perfectly allined
			VBox vbDrinks = new VBox();
			vbDrinks.setPadding(new Insets(0, 0, 0, 0));
			vbDrinks.setSpacing(10);
			vbDrinks.getChildren().addAll(lblCoke , lblSprite , lblOrange , lblRoot);

			VBox vbDrinkCho = new VBox();
			vbDrinkCho.setPadding(new Insets(0, 0, 0, 0));
			vbDrinkCho.setSpacing(2);
			vbDrinkCho.getChildren().addAll(cboCoke , cboSprite , cboOrange , cboRoot);

			//Then i add it to a tilepane
			TilePane tilePaneDrinks = new TilePane();
			tilePaneDrinks.setPrefColumns(2);
			tilePaneDrinks.setAlignment(Pos.CENTER_LEFT);
			tilePaneDrinks.getChildren().addAll(vbDrinks , vbDrinkCho);

			//and finally I put it on a titled pane
			TitledPane root2 = new TitledPane();
			root2.setText("Beverages:");
			root2.setCollapsible(false);
			root2.setContent(tilePaneDrinks);

			//Creating the label instructing the user that the first three toppings are free
			Label lblInstruct = new Label("First (3) toppings are free!");
			lblInstruct.setFont(Font.font("Verdana", 15));

			//Creating empty Spaces to be placed on the Grid (Sir i didn't know any other way of putting spaces on a gridpane so this i what i did)
			Label lblSpace = new Label();

			Label lblSpace1 = new Label();

			Label lblSpace2 = new Label();

			Label lblHSpace = new Label();
			lblHSpace.setPrefSize(10, 20);

			Label lblHSpace1 = new Label();
			lblHSpace1.setPrefSize(10, 20);

			//Inputting the pictures of the payment method
			Label lblPayment = new Label();
			lblPayment.setGraphic(new ImageView(new Image("file:PaymentOptions.png"))); 

			//This part of the Code controls the checkout prices
			//Creating the Labels 
			Label lblSub = new Label();
			lblSub.setText("SUBTOTAL: ");
			lblSub.setFont(Font.font("Verdana", 13));

			Label lblDeli = new Label();
			lblDeli.setText("DELIVERY FEE: ");
			lblDeli.setFont(Font.font("Verdana", 13));

			Label lblHst = new Label();
			lblHst.setText("HST: ");
			lblHst.setFont(Font.font("Verdana", 13));

			Label lblGrndTtl = new Label();
			lblGrndTtl.setText("GRAND TOTAL: ");
			lblGrndTtl.setFont(Font.font("Verdana", 13));

			//Creating the TextBoxes to show all the pricing
			TextField txtSub = new TextField();
			txtSub.setEditable(false);
			txtSub.setStyle("-fx-background-color: white");
			txtSub.setAlignment(Pos.CENTER);
			txtSub.setMaxSize(100, 20);

			TextField txtDeli = new TextField();
			txtDeli.setEditable(false);
			txtDeli.setStyle("-fx-background-color: white");
			txtDeli.setAlignment(Pos.CENTER);
			txtDeli.setMaxSize(100, 20);

			TextField txtHst = new TextField();
			txtHst.setEditable(false);
			txtHst.setStyle("-fx-background-color: white");
			txtHst.setAlignment(Pos.CENTER);
			txtHst.setMaxSize(100, 20);

			TextField txtGrndTtl = new TextField();
			txtGrndTtl.setEditable(false);
			txtGrndTtl.setStyle("-fx-background-color: white");
			txtGrndTtl.setAlignment(Pos.CENTER);
			txtGrndTtl.setMaxSize(100, 20);

			//Creating the VBox to put all the labels in
			VBox vbCheckout = new VBox();
			vbCheckout.setPadding(new Insets(10, 10, 10, 20));
			vbCheckout.setSpacing(20);
			vbCheckout.getChildren().addAll(lblSub , lblDeli , lblHst , lblGrndTtl);

			//Creating the VBox to put all the TextFields in
			VBox vbText = new VBox();
			vbText.setPadding(new Insets(10, 10, 20, 20));
			vbText.setSpacing(15);
			vbText.getChildren().addAll(txtSub , txtDeli , txtHst , txtGrndTtl);
			vbText.setAlignment(Pos.CENTER_RIGHT);

			//Putting both VBoxes onto a tilepane 
			TilePane tilePaneCost = new TilePane();
			tilePaneCost.setPrefColumns(2);
			tilePaneCost.setAlignment(Pos.CENTER_LEFT);
			tilePaneCost.getChildren().addAll(vbCheckout , vbText);

			//This part of the Code is the Buttons
			//Creating the Buttons
			//Checkout Button
			Button btnCheckout = new Button("CHECKOUT");
			btnCheckout.setDisable(true);
			btnCheckout.setPrefSize(80, 20);
			btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//This is me assignning what ever number is selected in the combobox and store it in a variable
					int value = Integer.parseInt(cboCoke.getValue());
					int value1 = Integer.parseInt(cboSprite.getValue());
					int value2 = Integer.parseInt(cboOrange.getValue());
					int value3 = Integer.parseInt(cboRoot.getValue());

					if(value == 0 && value1 == 0 && value2 == 0 && value3 ==0)
					{
						drinks += "\n None";
					}
					//This next part is for the drinks when it's being checked out (again sir I know there is a much easier way of doing this but i did not know it so 
					//did this instead)
					//So for this part of my code what it is doing is i have a string variable called drinks that is blank
					if(value == 0 || cboCoke.getPromptText().equals("0"))
					{
						drinks += "";
					}
					else
					{										
						drinks += "\n " +value +"x  Coke"; 
					}
					if(value1 == 0 || cboSprite.getPromptText().equals("0"))
					{
						drinks += "";
					}
					else
					{
						drinks += "\n " +value1 +"x  Sprite"; 
					}
					if(value2 == 0 || cboOrange.getPromptText().equals("0"))
					{
						drinks += "";
					}
					else
					{
						drinks += "\n " +value2 +"x  Orange"; 
					}
					if(value3 == 0 || cboRoot.getPromptText().equals("0"))
					{
						drinks += "";
					}
					else
					{
						drinks += "\n " +value3 +"x  Root"; 
					}

					
					//This part is for the radio buttons 
					if(radSmall.isSelected() == true)
					{
						small = "Small";
					}
					if(radMedium.isSelected() == true)
					{
						small = "Medium";
					}
					if(radLarge.isSelected() == true)
					{
						small = "Large";
					}
					if(radParty.isSelected() == true)
					{
						small = "Party";
					}
					if(chkMushrooms.isSelected() == false && chkPepperoni.isSelected() == false && chkPeppers.isSelected() == false && chkBacon.isSelected() == false &&
							chkOnions.isSelected() == false && chkTomatoes.isSelected() == false && chkRedPprs.isSelected() == false && chkExtraCheese.isSelected() == false)
					{
						toppings = "\n None";
					}
					if(chkMushrooms.isSelected() == true)
					{
						toppings = "\n - Mushrooms";
					}
					if(chkPepperoni.isSelected() == true)
					{
						toppings += "\n - Pepperoni";
					}
					if(chkPeppers.isSelected() == true)
					{
						toppings += "\n - Green Peppers";
					}
					if(chkBacon.isSelected() == true)
					{
						toppings += "\n - Bacon";
					}
					if(chkOnions.isSelected() == true)
					{
						toppings += "\n - Onions";
					}
					if(chkTomatoes.isSelected() == true)
					{
						toppings += "\n - Tomatoes";
					}
					if(chkRedPprs.isSelected() == true)
					{
						toppings += "\n - Hot Peppers";
					}
					if(chkExtraCheese.isSelected() == true)
					{
						toppings += "\n - Extra Cheese";
					}

					int choice = JOptionPane.showConfirmDialog(null,
							"Is this order correct?"
									+ "\n"
									+ "\nPIZZA:"
									+ "\n- " +small
									+"\n"
									+ "\nTOPPINGS:"
									+ toppings
									+"\n"
									+ "\nDRINKS"
									+ drinks
									+"\n"
									,
									"Order Summary",
									JOptionPane.YES_NO_OPTION);


					if (choice == JOptionPane.NO_OPTION ||
							choice == JOptionPane.CLOSED_OPTION)
					{

						btnCheckout.setDisable(true);
						toppings = "";
						drinks = "";

						e.consume();
					}
					else if (choice == JOptionPane.YES_OPTION)
					{
						ImageIcon imgIcon = new ImageIcon("littlecaesarsicon.png");
						JOptionPane.showMessageDialog(null,
								"Thank you for choosing Little Caesars!"
										+"\nYour pizza will be delivered in 30 minutes or it's free!",
										"Little Caesars",
										JOptionPane.INFORMATION_MESSAGE,
										imgIcon);
						System.exit(0);
					}
				}
			});

			//The Calculate Button
			Button btnCalc = new Button("CALCULATE");
			btnCalc.setPrefSize(80, 20);
			btnCalc.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//Checkes to see if any of the radiobuttons are selected, if so then it begins calculating
					if(radSmall.isSelected() == true || radMedium.isSelected() == true || radLarge.isSelected() == true || 
							radParty.isSelected() == true)
					{


						//ifthe user has chosen a size then it enables the checkout button first, then it adds all the prices 
						//printed in the textfields together, it also calculates the HST of the total
						btnCheckout.setDisable(false);
						total2 = myNumber + counter +counterTotal;
						double hst = total2 * 0.13;

						//After the total has been calculated it checkes to see if the total is over $15, if so then the delivery fee
						//is free and it just adds the total with the HST but does not add any delivery fee
						if(total2 > 15.00)
						{
							double ttl = total2 + hst;
							DecimalFormat format = new DecimalFormat("0.00"); 
							txtSub.setText("$" +(format.format(total2)));
							double zero = 0.00;
							DecimalFormat format1 = new DecimalFormat("0.00"); 
							txtDeli.setText("$" +(format1.format(zero)));
							txtDeli.setStyle("-fx-control-inner-background: green");
							DecimalFormat format2 = new DecimalFormat("0.00"); 
							txtHst.setText("$" +(format2.format(hst)));
							DecimalFormat format3 = new DecimalFormat("0.00"); 
							txtGrndTtl.setText("$" +(format3.format(ttl)));

						}
						//If the total is less than $15 then it does the same thing as the other program but, 
						//this time it adds a delivery fee of $5
						else
						{
							txtDeli.setStyle("-fx-control-inner-background: white");
							DecimalFormat format = new DecimalFormat("0.00"); 
							txtSub.setText("$" +(format.format(total2)));
							txtDeli.setText("$5.00");
							total2 = total2 + 5.00 +hst;
							DecimalFormat format2 = new DecimalFormat("0.00"); 
							txtHst.setText("$" +(format2.format(hst)));
							DecimalFormat format1 = new DecimalFormat("0.00"); 
							txtGrndTtl.setText("$" +(format1.format(total2)));
						}
					}
					//If none of the radio buttons are selected then it prints this error message
					else if(radSmall.isSelected() == false || radMedium.isSelected() == false || radLarge.isSelected() == false || 
							radParty.isSelected() == false)
					{
						JOptionPane.showMessageDialog(null, 
								"Your Order could not be completed! "
										+ "\nPlease select a pizza size.",
										"Incomplete Order",
										JOptionPane.ERROR_MESSAGE);
						e.consume();
					}

				}
			});

			//This is the clear button where i simply just reset everything and unckeck all the boxes
			Button btnClear = new Button("CLEAR");
			btnClear.setPrefSize(80, 20);
			btnClear.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//This is where i reset everything, i set all the values zero, and i unckeck the check boxes, set the combo boxes back to zero,
					//uncheck the radiobutton, and clear what ever price is in all the textfields, I also changed the delivery fee box back to white
					txtSize.setText("$0.00");

					txtToppings.setText("$0.00");

					txtDrinks.setText("$0.00");

					txtDeli.setStyle("-fx-control-inner-background: white");

					numChoices = 0;

					btnCheckout.setDisable(true);

					cboCoke.setValue("0");
					cboSprite.setValue("0");
					cboOrange.setValue("0");
					cboRoot.setValue("0");

					radSmall.setSelected(false);
					radMedium.setSelected(false);
					radLarge.setSelected(false);
					radParty.setSelected(false);

					chkMushrooms.setSelected(false);
					chkPepperoni.setSelected(false);
					chkPeppers.setSelected(false); 
					chkBacon.setSelected(false);
					chkOnions.setSelected(false);
					chkTomatoes.setSelected(false);
					chkRedPprs.setSelected(false);
					chkExtraCheese.setSelected(false);

					txtSub.setText("$0.00");

					txtDeli.setText("$0.00");

					txtHst.setText("$0.00");

					txtGrndTtl.setText("$0.00");
				}
			});

			//This is the Exit Button
			Button btnExit = new Button("EXIT");
			btnExit.setPrefSize(80, 20);
			btnExit.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					//This part of my code heppens whenever the user clickes the exit button 
					//it then askes them if they want to exit the program, if they click yes the program exits
					//if they click no or the close button it closes the popup and doesn't close the program
					int choice = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to exit?",
							"Little Caesars",
							JOptionPane.YES_NO_OPTION);

					if (choice == JOptionPane.NO_OPTION ||
							choice == JOptionPane.CLOSED_OPTION)
					{
						e.consume();
					}
					else if (choice == JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(null,
								"Thank you for choosing Little Caesars!",
								"Little Caesars",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
			});

			//Putting all the buttons into a VBox (cause it's the best)
			VBox vbButtons = new VBox();
			vbButtons.setPadding(new Insets(10, 10, 10, 20));
			vbButtons.setSpacing(15);
			vbButtons.getChildren().addAll(btnCalc , btnClear , btnCheckout , btnExit);

			//This is where I add the different methods to the GridPane, and set their positions
			root.add(lblLogo, 0, 0, 6, 1);
			GridPane.setHalignment(lblLogo, HPos.CENTER);
			root.add(ttlPane, 0, 1);
			root.add(lblHSpace, 1, 1);
			root.add(lblHSpace1, 3, 1);
			root.add(root1, 2, 1);
			root.add(root2, 4, 1);
			root.add(lblSpace, 2, 3);
			root.add(lblSpace1, 2, 5);
			root.add(lblSpace2, 1, 7);
			root.add(lblPayment, 0, 8);
			root.add(vbText, 2, 8);
			GridPane.setHalignment(lblPayment, HPos.CENTER);
			root.add(lblInstruct, 2, 4);
			root.add(txtSize, 0, 6);
			GridPane.setHalignment(txtSize, HPos.CENTER);
			root.add(txtToppings, 2, 6);
			GridPane.setHalignment(txtToppings, HPos.CENTER);
			root.add(txtDrinks, 4, 6);
			GridPane.setHalignment(txtDrinks, HPos.CENTER);
			GridPane.setHalignment(lblInstruct, HPos.CENTER);
			root.add(tilePaneCost, 2, 8);
			root.add(vbButtons, 4, 8);
			GridPane.setHalignment(vbButtons, HPos.CENTER);
			Scene scene = new Scene(root);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Little Caesars");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	//This is what happens when the check boxes are clicked
	private Object CheckBoxClicked(CheckBox chk) {
		//If any of the of the check boxes are clicked it adds one to my variable numChoices
		if (chk.isSelected())
		{
			numChoices++;

			//If the number of checkboxes that are selected is greater than 3 then it takes that
			//number and subtracts three from it, because the first three toppings are free
			//and what ever number is left is the cost. ex (4 - 3) = 1 dollar
			if(numChoices > 3)
			{
				counter = numChoices - 3; 
				DecimalFormat format = new DecimalFormat("0.00"); 
				txtToppings.setText("$" +(format.format(counter)));
			}
		}
		//What happens here happens when the check boxes are unselected
		else if(chk.isSelected() == false)
		{
			//Whenver a checkbox is unclicked then it subtracts one from the variable numChoices
			numChoices--;

			//If the number of check boxes clicked is less than 3 then it removes the added cost and prints out that
			//the selected toppings cost $0.00
			if(numChoices <= 3)
			{
				txtToppings.setText("$0.00");
			}
			//What happens in this else statement handels what happens when more than 3 check boxes are selected, 
			//if this line of code wasn't there then numchoices would just keep subtracting one, and negative numbers would be displayed
			//so when the user has more than 3checkboxex clicked it does the same thing as the line above, and takes however many check boxes
			//that are selected and subtracts 3 from it, and prints that answer
			else
			{
				counter = numChoices - 3; 
				DecimalFormat format = new DecimalFormat("0.00"); 
				txtToppings.setText("$" +(format.format(counter)));
			}
		}
		return chk;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
