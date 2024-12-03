package com.backend.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CakeDTO {
  private Long patissierId;
  private String nom;
  private String image;
  private String description;
  private Double prix;
}
