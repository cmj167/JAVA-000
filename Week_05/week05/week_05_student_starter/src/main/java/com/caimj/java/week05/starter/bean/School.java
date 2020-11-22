package com.caimj.java.week05.starter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "school")
@Component
public class School {

    private int  schoolId;
    private String schoolName;
    private List<Klass> klasses = new ArrayList<>();
}
