package com.address.addressproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false,unique = true,length = 255)
    private String name;

    @NotNull
    @Column(nullable = false,unique = true,length = 20)
    private String postCode;


    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_country_id"))
    private Country country;

    @OneToMany (mappedBy = "city")
    private   Set<Neighborhood> neighborhoods;
}
