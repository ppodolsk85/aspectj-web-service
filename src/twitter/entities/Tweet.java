package twitter.entities;

import com.agh.toik.webservice.annotations.*;

/**
 * Created by piotrpodolski on 26/04/15.
 */

@Entity
@Create(url="statuses/update", method="POST")
@List(url="statuses/user_timeline", method="GET")
@Delete(url="statuses/destroy/:id", method="POST")
public class Tweet {
	@Field
	private String id_str;

	@Field
	private String text;
}
