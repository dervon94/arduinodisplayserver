package hu.miskolc.uni.iit.arduinodisplayserver.controller;

import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.arduinodisplayserver.DTO.RequestDTO;
import hu.miskolc.uni.iit.arduinodisplayserver.service.DisplayService;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;

@Controller
public class DisplayRestController {
    @Autowired
    DisplayService displayService;

    @RequestMapping(value = {"/listByIp"}, method = {RequestMethod.GET})
    @ResponseBody
    public String showSensorsByIP() {
        return displayService.getSensorValuesByIpAddress("192.168.2.9").toString();
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String listAllDeviceConsole() {
        final List<MeasuringDevice> all;
        all = displayService.getallmeasureddata();
        System.out.println(all);
        return all.toString();
    }

    @RequestMapping(value = "/listMeasurings", method = {RequestMethod.POST}, consumes = "application/json")
    @ResponseBody
    public String listAllDeviceConsole(@RequestBody final RequestDTO requestDTO) {
        final List<ResultData> result;
        final Calendar begin = requestDTO.getBegin().toGregorianCalendar();
        final Calendar end = requestDTO.getEnd().toGregorianCalendar();
        try {
            final MeasuringType measuringType = MeasuringType.valueOf(requestDTO.getType().toUpperCase());
            result = displayService.getMeasuredValuesBetweeenDates(begin, end, requestDTO.getDeviceId(), measuringType);
            return result.toString();
        } catch (final IllegalArgumentException e) {
            return "Hibás Paraméter";
        }

    }

}
