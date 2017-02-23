package phonebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phonebook.entity.Phonebook;
import phonebook.service.PhoneBookService;

import java.util.List;

/**
 * Created by Admin on 19.02.2017.
 */
@Controller
@RequestMapping("/")
public class HomeController {

   /* @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "index";
    }*/

    @Autowired
    PhoneBookService service;

    @RequestMapping(value={"/","/phonebook"}, method = RequestMethod.GET)
    public String listRecords(ModelMap modelMap){
        List<Phonebook> records = service.findAllRecords();
        modelMap.addAttribute("records",records);
        return "index";
    }

    @RequestMapping(value = {"/phonebook/delete-{telNumber}"},method = RequestMethod.GET)
    public String deleteRecord(@PathVariable String telNumber){
        service.deleteRecordByTelNumber(telNumber);
        return "redirect:/phonebook";
    }

    @RequestMapping(value={"/phonebook/json"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Phonebook> json() throws JsonProcessingException {
        List<Phonebook> records = service.findAllRecords();
      // modelMap.addAttribute("records",records);

        return records;
    }
}
