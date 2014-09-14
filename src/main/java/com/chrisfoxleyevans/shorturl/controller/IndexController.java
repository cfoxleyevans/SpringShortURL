package com.chrisfoxleyevans.shorturl.controller;

import com.chrisfoxleyevans.shorturl.service.EntryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    EntryService entryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam(value = "code", required = false) String code) {
        if (code != null) {
            return new ModelAndView("redirect:" + entryService.getLongUrl(code));
        } else {
            return new ModelAndView("index");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createNewShortUrl(@RequestParam(value = "url", defaultValue = "hello", required = false) String url) {
        String code = entryService.checkForURL(url);
        ModelAndView modelAndView = new ModelAndView("index");
        if (code != null) {
            modelAndView.addObject("shortCode", code);
        } else {
            modelAndView.addObject("shortCode", entryService.create(url));
        }
        return modelAndView;
    }
}
