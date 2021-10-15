package moh.fa2021.cse201f.g4.appcatalogdemo.controllers;

import moh.fa2021.cse201f.g4.appcatalogdemo.models.App;
import moh.fa2021.cse201f.g4.appcatalogdemo.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String org,
                                    @RequestParam(required = false) Integer page) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page, 50);


        return ResponseEntity.ok(appService.search(name, org, pageable));
    }

}
