package com.millervein.callscorecard;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Scorecard {
	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty
	private String reviewer;
	@NotEmpty
	private String reviewee;
	@NotEmpty
	@Column(unique=true)
	private String callId;
	@ElementCollection
	private Map<String, Boolean> criteria;

	public Integer getId() {
		return id;
	}

	public String getReviewer() {
		return reviewer;
	}

	public String getReviewee() {
		return reviewee;
	}

	public String getCallId() {
		return callId;
	}

	public Map<String, Boolean> getCriteria() {
		return criteria;
	}
	
	public Float getScore(){
		Integer points = 0;
		for(Boolean val : this.criteria.values()){
			points += (val) ? 1 : 0;
		}
		Integer possiblePoints = this.criteria.size();
		return (float) points/possiblePoints;
	}

}
