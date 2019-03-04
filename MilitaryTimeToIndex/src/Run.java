public class Run {
	public static void main(String[] args) {
		//test case one: valid with 30 minutes
		System.out.println("Expected 25 because 12 * 2 = 24 and one is added because of the 30 minutes");
		System.out.println(computeIndexFromTime("1230"));
		System.out.println();
		//test case two: valid with zero minutes
		System.out.println("Expected 10 because 5 * 2 = 10 and one is not added");
		System.out.println(computeIndexFromTime("0500"));
		System.out.println();
		//test case three: invalid length
		System.out.println("Expected -1 and an error message because the length is invalid");
		System.out.println(computeIndexFromTime("500"));
		System.out.println();
		//test case four: invalid hour
		System.out.println("Expected -1 and an error message because the hour is invalid");
		System.out.println(computeIndexFromTime("2500"));
		System.out.println();
		//test case five: invalid minute
		System.out.println("Expected -1 and an error message because the minute is invalid");
		System.out.println(computeIndexFromTime("2323"));
	}

	public static int computeIndexFromTime(String time) {
		//ensure length is exactly four
		if(time.length() != 4) {
			System.out.println("Error: string must be exactly four characters");
			return -1;
		}
		//parse hour from substring
		String hourString = time.substring(0, 2);
		int hourInteger = Integer.parseInt(hourString);
		//parse minute from substring
		String minuteString = time.substring(2, 4);
		int minuteInteger = Integer.parseInt(minuteString);
		//ensure valid hour
		if(hourInteger < 0 || hourInteger > 23) {
			System.out.println("Error: hour must be greater than zero and less than 23");
			return -1;
		}
		//ensure valid minute
		if(minuteInteger != 0 && minuteInteger != 30) {
			System.out.println("Error: minute must be zero or 30");
			return -1;
		}
		//calculate index
		int index = 2 * hourInteger;
		if(minuteInteger == 30) {
			index++;
		}
		return index;
	}
}
