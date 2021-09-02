package com.example.toDoApp.entrypoint.web.vm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class toDoVm {
    private String desc;
    private String title;
}
