package com.address.addressproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @NotNull
    @Length(min = 2, max = 2, message = "Country code shout be only 2 characters ")
    @Column(unique = true, nullable = false)
    private String code_Alpha2;


    //@OneToMany(mappedBy = "country")
   // private Set<City> cities;


}
