package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //With this annotation, we will ignore the fields that does not fit the fields in this class.

public class JsonPlaceHolderPojo {
    //Create private variables for each field
    private Integer userId;
    private String title;
    private Boolean completed;

    //Create constructors with parameters and without parameters
    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //Create Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //Create ToString
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo [ " +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ']';
    }


}
