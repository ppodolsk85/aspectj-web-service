package twitter;

import java.util.Scanner;

public class Main {

	public static void listTweets() {

	}

	public static void deleteTweet() {

	}

	public static void tweet() {

	}

	public static void showMenu() {
		System.out.print("")
	}

    public static void main(String[] args) {
		int option = -1;
		Scanner s = new Scanner(System.in);

		while(option != 0) {
			showMenu();
			option = s.nextInt();
			switch(option) {
				case 1:
					listTweets();
					break;
				case 2:
					deleteTweet();
					break;
				case 3:
					tweet();
					break;
			}
		}
    }
}
