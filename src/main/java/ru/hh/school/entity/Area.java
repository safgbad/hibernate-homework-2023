package ru.hh.school.entity;

import javax.persistence.*;

// DONE: оформите entity
@Entity
public class Area {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer id;

  @Column(nullable = false)
  private String name;

  public Area() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
