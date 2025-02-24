package com.mphasis.RealEstateManagementSystem.dto;

import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;

public class UserRequest {
	private User user;
    private UserCommonDetails userCommonDetails;

    
    
    public UserRequest() {
		super();
	}

	public UserRequest(User user, UserCommonDetails userCommonDetails) {
		super();
		this.user = user;
		this.userCommonDetails = userCommonDetails;
	}

	// Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCommonDetails getUserCommonDetails() {
        return userCommonDetails;
    }

    public void setUserCommonDetails(UserCommonDetails userCommonDetails) {
        this.userCommonDetails = userCommonDetails;
    }

	@Override
	public String toString() {
		return "UserRequest [user=" + user + ", userCommonDetails=" + userCommonDetails + "]";
	}
    
}
