package com.JPAMVCH2.JPAH2demoApp.controller;

import com.JPAMVCH2.JPAH2demoApp.dao.PersonRepo;
import com.JPAMVCH2.JPAH2demoApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    PersonRepo repo;

    @RequestMapping("new")
    public String home(){
        return "home.jsp";
    }
/*    @RequestMapping("addPerson")
    public String addPerson(Person person){
        repo.save(person);
        return "home.jsp";
    }
*/
    @RequestMapping("/getPerson")
    public ModelAndView getPerson(@RequestParam int id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showPerson.jsp");
        Person person = repo.findById(id).orElse(new Person());
        //repo.delete(person);
       // System.out.println(repo.findByage(20));
        //System.out.println(repo.findByageSorted(20));
        mv.addObject(person);
        return mv;
    }

    @RequestMapping("/persons")
    //@ResponseBody
    public List<Person> getPersons(){
        return repo.findAll();
    }

    @RequestMapping("/person/{id}")
    //@ResponseBody
    public Optional<Person> getPersonDetails(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @PostMapping("person")
    public Person addPerson(@RequestBody Person person){
        repo.save(person);
        return person;
    }

    @DeleteMapping("/person/{id}")
    public List <Person> deletePerson(@PathVariable("id") int id){
        Person person = repo.getOne(id);
        repo.delete(person);
        return repo.findAll();
    }

    @PutMapping("/person")
    public List <Person> saveOrUpdate (@RequestBody Person person){
        repo.save(person);
        return repo.findAll();
    }
}
