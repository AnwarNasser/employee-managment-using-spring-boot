package com.example.Employee.Child;

import com.example.Employee.baseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.hibernate.cfg.AvailableSettings.USER;

@RestController
@RequestMapping("/childData")
public class ChildController extends baseController {
    @Autowired
    ChildService childService;

    @PostMapping("/save")
    public ChildData saveChildData(@RequestBody ChildData childData)
    {
        // childService.findByUser(getCurrentUser().getId());
        return childService.saveChildData(childData);
    }
    // author of admin
    //@PreAuthorize("hasAuthority('ADMIN')")
    /*
         this is method allow user and admin to getAllChild , because in authorize /user means hasRole USER , ADMIN
         لاززم ال url الي ب authorization ترتب بنفس الدوال حق الكلاسات
    * */
   /* @RequestMapping(value="/user", method=RequestMethod.GET)
    public ResponseEntity<List<ChildDataViewDto> >  getAllChild()
    {    // currentUser : how is user get all child
       List<ChildData> result = childService.findByUser(getCurrentUser().getId());
       return new ResponseEntity(result, HttpStatus.OK);
    }*/
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<ChildData>  getAllChild()
    {    // currentUser : how is user get all child
        List<ChildData> childData = childService.findByUser(getCurrentUser());
        return childData;
    }
    //@PreAuthorize("hasAuthority('USER')")
   // @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    //@RolesAllowed(USER)
    @GetMapping("/{id}")
    public ChildData getChildById(@PathVariable Long id)
    {
        return childService.getChildById(id);
    }
    @PutMapping("/{id}")
    public ChildData updateChild(@PathVariable Long id,@RequestBody ChildData childData)
    {
        return childService.updateChild(id,childData);
    }
    @DeleteMapping("/{id}")
    public ChildData deleteChild(@PathVariable Long id,@RequestBody ChildData childData)
    {
        return childService.deleteChild(id,childData);
    }
}
