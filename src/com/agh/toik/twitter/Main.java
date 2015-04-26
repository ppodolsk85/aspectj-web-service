package com.agh.toik.twitter;

import java.util.Collection;
import java.util.Scanner;

import com.agh.toik.twitter.entities.Tweet;
import com.agh.toik.webservice.entities.IEntity;

public class Main {
	static Scanner s;

	public static void listTweets() {
		Collection<IEntity> tweets = Tweet.getAll();
		if(tweets != null) {
			System.out.println("No of tweets:" + tweets.size());
			for(IEntity tweet : tweets) {
				Tweet t = (Tweet) tweet;
				System.out.println("Id: " + t.getIdStr() + " Message: " + t.getText());
			}
		} else {
			System.out.println("No tweets, sorry :(");
		}
		System.out.println("\n");
	}

	public static void deleteTweet() {
	}

	public static void tweet() {
		System.out.print("Message (140 chars): " );
		String message = s.next();
	}

	public static void showMenu() {
		System.out.print("Choose an option:\n" +
				"0: Exit\n" +
				"1: List all tweets\n" +
				"2: Delete a tweet\n" +
				"3: Add a new tweet\n\n" );
	}

    public static void main(String[] args) {
		int option = -1;
		s = new Scanner(System.in);

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
