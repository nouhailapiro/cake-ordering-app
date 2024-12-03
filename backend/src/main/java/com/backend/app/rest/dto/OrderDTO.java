package com.backend.app.rest.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
  private Long clientId;
  private List<Long> cakes;
  private Date date;
  private String typeLivraison;
  private String adresseLivraison;
  private Double total;
}
