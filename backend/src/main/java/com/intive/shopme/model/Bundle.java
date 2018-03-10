package com.intive.shopme.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@ApiModel(value = "Offer's Bundle", description = "Represents different bundle types of offer")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bundle {

    @ApiModelProperty(value = "Represents bundle's id number")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @NotNull(message = "Description cannot be empty.")
    @Size(max = 500, message = "Too many characters.")
    @ApiModelProperty(value = "Represents bundle's description")
    private String description;

    @ApiModelProperty(value = "Represents bundle's price")
    private String price;

}
