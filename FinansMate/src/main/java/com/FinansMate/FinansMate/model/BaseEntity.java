package com.FinansMate.FinansMate.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  @Column(name = "create_at")
  private LocalDateTime createAt;

  @Column(name = "update_at")
  private LocalDateTime updateAt;

  @Column(name = "deleted")
  private Boolean deleted;

  @PrePersist
  protected void prePersist() {
    createAt = LocalDateTime.now();
    updateAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void preUpdate() {
    updateAt = LocalDateTime.now();
  }
}
