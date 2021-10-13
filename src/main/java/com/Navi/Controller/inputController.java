package com.Navi.Controller;

import com.Navi.Service.impl.naviServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class inputController {
    @Autowired
    naviServicesImpl naviServices;




    @RequestMapping(value = "/routeData", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Boolean> processFile(HttpServletRequest httpServletRequest)
    {
        String file = getClass().getClassLoader().getResource("ivtest2.csv").getFile();
        boolean x = naviServices.processFile(file);
        return new ResponseEntity<Boolean>(x, new HttpHeaders(), HttpStatus.OK);
    }

}
