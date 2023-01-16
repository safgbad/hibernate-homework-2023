package ru.hh.school.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// DONE: оформите entity
@Entity
public class Employer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employer_id")
  private Integer id;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  // не используйте java.util.Date
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime-java8
  @Column(name = "creation_time")
  private LocalDateTime creationTime;

  @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
  private List<Vacancy> vacancies = new ArrayList<>();

  @Column(name = "block_time")
  private LocalDateTime blockTime;

  public Employer() {}

  public List<Vacancy> getVacancies() {
    return vacancies;
  }

  public Integer getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public LocalDateTime getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(LocalDateTime blockTime) {
    this.blockTime = blockTime;
  }

  // статьи на тему реализации equals() и hashCode():
  //
  // https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
  // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employer employer = (Employer) o;

    EqualsBuilder eb = new EqualsBuilder();
    eb.append(companyName, employer.companyName);

    return eb.isEquals();
  }

  @Override
  public int hashCode() {
    HashCodeBuilder hb = new HashCodeBuilder();
    hb.append(companyName);

    return hb.toHashCode();
  }

}
