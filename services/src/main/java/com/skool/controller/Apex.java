package com.skool.controller;

import com.skool.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Scope(value = "request")
@RequestMapping("/api/v1")
public class Apex {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static Logger LOG = LoggerFactory.getLogger(Apex.class);


    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value="/info"  , method = RequestMethod.GET)
    public StudentDao info (@RequestParam(value="name", defaultValue="World") String name) {
        return new StudentDao(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value="/ping"  , method = RequestMethod.GET)
    public Response ping() {
        String response ="I'm OK. UTC Date:"  + new Date().toString();

        return Response.ok(response).build();
    }

}