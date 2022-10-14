package games;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
	public Game(){}
	public Game(int reviewScore, String releaseDate, String name, String rating, int id, String category) {
		setReviewScore (reviewScore);
		setReleaseDate (releaseDate);
		setName (name);
		setRating (rating);
		setId (id);
		setCategory (category);
	}

	@JsonProperty("reviewScore")
	private int reviewScore;

	@JsonProperty("releaseDate")
	private String releaseDate;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rating")
	private String rating;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private String category;

	public void setReviewScore(int reviewScore){
		this.reviewScore = reviewScore;
	}

	public int getReviewScore(){
		return reviewScore;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}
}