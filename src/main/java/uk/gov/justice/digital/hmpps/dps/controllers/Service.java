package uk.gov.justice.digital.hmpps.dps.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {

    private String name;

    private String description;

    private String url;

    private boolean healthOk;
}
