package com.sontieu.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "trains")
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", length= 1000)
	private String description;
	
	@Column(name = "distance_between_stop")
	private String distanceBetweenStop;
	
	@Column(name = "max_speed")
	private String maxSpeed;
	
	@Column(name = "sharing_tracks")
	private boolean sharingTracks;
	
	@Column(name = "grade_crossing")
	private boolean gradeCrossing;
	
	@Column(name = "train_frequency")
	private String trainFrequency;
	
	@Column(name = "amenities")
	private String amenities;
}
