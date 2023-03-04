package com.siigo.automation.model.models.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"user", "name"})
public class Client {

    private String name;
    private User user;
}

