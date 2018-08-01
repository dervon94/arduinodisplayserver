package hu.miskolc.uni.iit.arduinodisplayserver.controller;

import hu.miskolc.uni.iit.arduinodisplayserver.service.DisplayService;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DisplayRestController {
    @Autowired
    DisplayService displayService;

    @RequestMapping(value = {"/listByIp"}, method = {RequestMethod.GET})
    @ResponseBody
    public String showRunnerById() {
        return displayService.getSensorValuesByIpAddress("192.168.2.8").toString();
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String listAllDeviceConsole() {
        final List<MeasuringDevice> all;
        all = displayService.getallmeasureddata();
        System.out.println(all);
        return all.toString();
    }
}
