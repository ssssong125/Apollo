package com.b4.apollo.contact.controller;

import com.b4.apollo.contact.model.dto.ContactDTO;
import com.b4.apollo.contact.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    private final MessageSource messageSource;

    @GetMapping("/admin/contactList")
    public ModelAndView findAllContent(ModelAndView mv){
        List<ContactDTO> contactList = contactService.findAllContent();
        contactList.stream().forEach(contact -> System.out.println("contact = " + contact));
        mv.addObject("contactList", contactList);
        mv.setViewName("admin/contactList");
        return mv;
    }
    @GetMapping("/main/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/main/contact")
    public ModelAndView sendContent(ModelAndView mv, ContactDTO contactDTO, RedirectAttributes rttr, Locale locale) throws Exception{
        contactService.sendContent(contactDTO);
        mv.setViewName("redirect:/main");
        rttr.addFlashAttribute("sendSuccessMessage", messageSource.getMessage("sendContent", null, locale));
        return mv;
    }


}
