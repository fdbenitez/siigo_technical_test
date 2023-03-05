package com.siigo.automation.model.bodys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractCreateBody implements CreateBody {
    private String nameService;
}
