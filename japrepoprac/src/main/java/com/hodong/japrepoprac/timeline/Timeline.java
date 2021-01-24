package com.hodong.japrepoprac.timeline;

import org.joda.time.DateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "timelines")
@Access(AccessType.FIELD)
public class Timeline {

    @Id
    @GeneratedValue
    private Long id;

    private String user;
    private String title;

    @Lob
    private String description;

    private DateTime createdAt;
    private DateTime updatedAt;

    public Timeline() {
        
    }

    public Timeline(String user, String title, String description) {
        this(user, title, description, new DateTime());
    }

    public Timeline(String user, String title, String description, DateTime createAt) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.createdAt = createAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
    }
  
    @Override
    public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
    }
  
    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }
}