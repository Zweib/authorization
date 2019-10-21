package com.chang.shiro.authorization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Entry {

    @RequestMapping(value = "/entry/hello", method = RequestMethod.PUT)
    @ResponseBody
    public String putHello() {
        return "hello";
    }

    @RequestMapping(value = "/entry/hello", method = RequestMethod.POST)
    @ResponseBody
    public String postHello() {
        return "hello";
    }

    @RequestMapping(value = "/entry/hello", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteHello() {
        return "hello";
    }


    @RequestMapping(value = "/entry/hi", method = RequestMethod.PUT)
    @ResponseBody
    public String putHi() {
        return "hi";
    }

    @RequestMapping(value = "/entry/hi", method = RequestMethod.POST)
    @ResponseBody
    public String postHi() {
        return "hi";
    }

    @RequestMapping(value = "/entry/hi", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteHi() {
        return "hi";
    }

}
