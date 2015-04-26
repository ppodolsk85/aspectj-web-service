package com.agh.toik.twitter.entities;

import java.util.ArrayList;
import java.util.Collection;

import com.agh.toik.webservice.annotations.*;
import com.agh.toik.webservice.entities.IEntity;

/**
 * Created by piotrpodolski on 26/04/15.
 */

@Entity
public class Tweet implements IEntity {
	@Field
	private String id_str;

	@Field
	private String text;
	
	public String getIdStr() {
		return id_str;
	}
	
	public String getText() {
		return text;
	}
	
	@List(url="statuses/user_timeline", method="GET")
	public static Collection<IEntity> getAll() {
		Collection<IEntity> tweets = new ArrayList<IEntity>();
		return tweets;
	}
	
	@Create(url="statuses/update", method="POST")
	public void save() {
		System.out.println("Tweet created!");
	}
	
	@Delete(url="statuses/destroy/:id_str", method="POST")
	public void remove() {
		System.out.println("Tweet deleted!");
	}
}
