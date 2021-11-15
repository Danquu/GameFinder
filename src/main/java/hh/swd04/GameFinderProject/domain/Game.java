package hh.swd04.GameFinderProject.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Game {
	
	
	
@Id @GeneratedValue private Long id;
private String title;
private String desc;
private int releaseyear;
private String developer;
private String publisher;
private Double price;

//TODO: TARKISTA!!!
@ManyToOne
@JsonIgnoreProperties ("games")
@JoinColumn(name = "genreid")
private Genre genre;


public Game() {
	super();

}

public Game(String title, String desc, int releaseyear, String developer, String publisher, Double price, Genre genre) {
	super();
	this.title = title;
	this.desc = desc;
	this.releaseyear = releaseyear;
	this.developer = developer;
	this.publisher = publisher;
	this.price = price;
	this.genre = genre;
}


public Game(String title, String desc, String developer, String publisher, Double price, Genre genre) {
	super();
	this.title = title;
	this.desc = desc;
	this.developer = developer;
	this.publisher = publisher;
	this.price = price;
	this.genre = genre;
}

public Game(String title, Genre genre, String desc, int releaseyear, String developer, String publisher, Double price) {
	super();
	this.title = title;
	this.genre = genre;
	this.desc = desc;
	this.releaseyear = releaseyear;
	this.developer = developer;
	this.publisher = publisher;
	this.price = price;
	
}



public Long getId() {
	return id;
}

public String getTitle() {
	return title;
}

public String getDesc() {
	return desc;
}

public int getReleaseyear() {
	return releaseyear;
}

public String getDeveloper() {
	return developer;
}

public String getPublisher() {
	return publisher;
}

public Double getPrice() {
	return price;
}

public Genre getGenre() {
	return genre;
}

public void setId(Long id) {
	this.id = id;
}

public void setTitle(String title) {
	this.title = title;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public void setReleaseyear(int releaseyear) {
	this.releaseyear = releaseyear;
}

public void setDeveloper(String developer) {
	this.developer = developer;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public void setPrice(Double price) {
	this.price = price;
}

public void setGenre(Genre genre) {
	this.genre = genre;
}

@Override
public String toString() {
	return "Game [id=" + id + ", title=" + title + ", desc=" + desc + ", releaseyear=" + releaseyear + ", developer="
			+ developer + ", publisher=" + publisher + ", price=" + price + ", genre=" + genre + "]";
}
















}
