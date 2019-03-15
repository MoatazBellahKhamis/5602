package atm;

public class Services {

	private double currentBalance = 300.0;
	HomePage homepage;
	String[] history = new String[5];
	//private double t;
	private int i, j, s;
	private int maxIndex;

	////////////////////////////////////////////////////////////////
	// DEPOSIT FUNCTION//

	public void depositCash(double added) {
		setCurrentBalance(getCurrentBalance() + added);
	}

	///////////////////////////////////////////////////////////////
	// WITHDRAW FUNCTION//

	public boolean withdrawCash(double added) {
		if (added <= getCurrentBalance()) {
			setCurrentBalance((getCurrentBalance() - added));

			return true;
		} else
			return false;
	}

	////////////////////////////////////////////////////////////////
	// HISTORY FUNCTIONS//

	public void add(String GivenValue) {
		if (i <= 4) {  							//<=4 because we want to show the last 5 transactions
			history[i] = GivenValue;
			maxIndex = i;
			j = i;								//J is just a checker to know if we hit the floor or the ceil
			i++;
		} else {								// else we have to shift the last 5 transactions
			s = 0;
			while (s < 4) {
				history[s] = history[s + 1];	//shifting
				s++;
			}
			history[s] = GivenValue;
			i--;		
			j = i;
		}

	}
//////////////////////////////////
	public String previous() {
		if (j > 0 && j <= maxIndex)
			--j;
		return history[j];
	}

	public String next() {
		if (j >= 0 && j < maxIndex)
			++j;
		return history[j];
	}
//////////////////////////////////
	public boolean checkNumber(String wihtdrawlValue) {
		boolean numeric;
		numeric = wihtdrawlValue.matches("-?\\d+(\\.\\d+)?"); // checks if number or string
															 // if true then it`s a number
		if (numeric)
			return true;
		else
			return false;
	}

	public String[] print() {
		String[] x = new String[history.length];
		for (j = 0; j < history.length; j++)
			x[j] = history[j];
		return x;
	}

	/////////////////////
	// Setters & Getters//
	/////////////////////

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}


	public int getMaximum() {
		return maxIndex;
	}

}
