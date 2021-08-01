package com.example.Employee.Child;

import com.example.Employee.ConvertService;
import com.example.Employee.Dto.ChildDataViewDto;
import com.example.Employee.exception.RecordExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    ConvertService convertService;
    // currentUser in service
    public  List<ChildData> findByUser(UserDetails userId){
        return childRepository.findByuserId(userId);
    }

    public ChildData saveChildData(ChildData childData)
    {
        if (childRepository.findByChildName(childData.getChildName()) !=null)
        {
            throw new  RecordExistException("Another record exit with same title");
        }
        childData.setActive(true);
        return childRepository.save(childData);
    }
    public List<ChildDataViewDto> getAllChild()
    {
        List<ChildData>  childdateils = childRepository.getAllChildData().orElse(new ArrayList<>());
        return childdateils.stream().map(convertService::convertChildDataToDto).collect(Collectors.toList());
    }
    public ChildData getChildById(Long id)
    {
        return childRepository.findById(id).get();

    }
    public ChildData updateChild(Long id,ChildData childData)
    {
        ChildData childData1 = childRepository.findById(id).get();
        childData1.setChildName(childData.getChildName());
        childData1.setDateOfBirth(childData.getDateOfBirth());
        childData1.setActive(childData.getActive());
        childRepository.save(childData1);
        return childData1;
    }
    public ChildData deleteChild(Long id,ChildData childData)
    {
        ChildData childData1=childRepository.findById(id).get();
        childData1.setActive(false);
        return childData1;
    }


}
