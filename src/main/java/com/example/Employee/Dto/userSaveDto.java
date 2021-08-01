package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userSaveDto {
    private int id;
    private String userName;
    private String password;
    private Boolean active;
    private String roles;
}
