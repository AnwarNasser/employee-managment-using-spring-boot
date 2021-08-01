package com.example.Employee.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDataViewDto {
    private Long ChildId;
    private String ChildName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date DateOfBirth;
    private Boolean Active;
    private int userId;
}
