package com.example.jdkdozer.res;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class UserVo {
    private String name;

    private List<String> friendNameList;

    private Integer age;

    private boolean ifMarried;

    private Date birthday;

    private String daughter;
}
