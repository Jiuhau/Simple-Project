package com.example.springwebsocket.controller;

import com.example.springwebsocket.webscoket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {
    @Autowired
    WebSocketServer webSocketServer;

    @PostMapping("/test")
    @ResponseBody
    public String test() throws IOException {
        System.out.println("申请接口请求");
        webSocketServer.onMessage("发送websocket");
        return "success";
    }
    public CommonResponseVO homePage(JSONObject jsonObject) {

        Date beginTime = jsonObject.getDate("beginTime");
        Date endTime = jsonObject.getDate("endTime");
        if (Objects.isNull(beginTime) || Objects.isNull(endTime)) {
            return CommonResponseVO.ok().message("缺少日期参数！");
        }
        HomePageVo homePageVo = new HomePageVo();

        List<String> dealerCodes = UserUtil.getDelaerCodeByToken(jsonObject.getString("token"));
        int size = dealerCodes.size(); //站点数
        if (CollectionUtils.isEmpty(dealerCodes) || size<=0) {
            dealerCodes.add("权限下没有dealerCodes");
            log.info("首页统计：用户权限下没有dealerCodes");
            return CommonResponseVO.ok().message("首页饼状图+顶部统计：用户无权限查看数据!");
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("dealerCodes", dealerCodes);
        ResponseEntity<?> responseEntity = workShopFeignService.queryServiceInfoListByDealerCode(map);
        List<String> dealerNames = new ArrayList<>();
        try {
            PageInfo<Map> pageInfo = PageQueryUtil.getPageInfoDataByResponseEntity(responseEntity, Map.class);
            List<Map> list = pageInfo.getList();
            dealerNames = list.stream().map(o -> {
                String dealerName = (String) o.get("dealerName");
                return dealerName;
            }).collect(Collectors.toList());
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        homePageVo.setStationCount(size);
        //设备总数
        Condition condition = new Condition(ActionDevice.class);
        condition.createCriteria().andIn("stationCode", dealerCodes)
                .andEqualTo("status", 1);
        int deviceCount = actionDeviceMapper.selectCountByCondition(condition);
        homePageVo.setDeviceCount(deviceCount);
        //预警业务数
        Condition condition1 = new Condition(StationAction.class);
        condition1.createCriteria().andIn("stationCode", dealerCodes)
                .andEqualTo("status", 1);
        int setUpCount = stationActionMapper.selectCountByCondition(condition1);
        homePageVo.setSetUpCount(setUpCount);
        //报警数量
        Condition condition2 = new Condition(Event.class);
        condition2.createCriteria().andIn("stationCode", dealerCodes)
                .andEqualTo("status", 3);
        List<Event> events = eventMapper.selectByCondition(condition2);
        //预警小灯
        List<Event> flashLight = events.stream().filter(e -> e.getStatus() != null).filter(e -> e.getStatus() == 3).collect(Collectors.toList());
        homePageVo.setAlarmCount(events.size());
        homePageVo.setPendingCount(flashLight.size());
        if ( CollectionUtils.isEmpty(events) || events.size()<=0 ) {
            return CommonResponseVO.ok().data(homePageVo).message("首页饼状图+顶部统计！");
        }

        List<Event> collect = events.stream().filter(o ->
                beginTime.before(o.getCreateDate()) && endTime.after(o.getCreateDate())).collect(Collectors.toList());
        List<String> eventStationNames = collect.stream().map(Event::getStationName).collect(Collectors.toList());
        dealerNames.removeAll(eventStationNames);

        Map<String, Long> stationGroupBy = collect.stream().collect(Collectors.groupingBy(Event::getStationName, Collectors.counting()));
        Map<String, Object> actionDbtMap = new LinkedHashMap<>();
        for (String s : stationGroupBy.keySet()) {
            int i = stationGroupBy.get(s).intValue();
            float v = new BigDecimal(i*100).divide(new BigDecimal(collect.size()), 2, RoundingMode.HALF_DOWN).floatValue();
//            double c = (double) (Math.round(100*(double)i/collect.size())/100.0);
            actionDbtMap.put(s, v);
        }
        for (String dealerName : dealerNames) {
            actionDbtMap.put(dealerName, 0);
        }
        Map<String, Long> actionGroupBy = collect.stream().collect(Collectors.groupingBy(Event::getActionName, Collectors.counting()));
        Map<String, Object> alarmDbtMap = new LinkedHashMap<>();
        for (String s : actionGroupBy.keySet()) {
            int i = actionGroupBy.get(s).intValue();
            float v = new BigDecimal(i*100).divide(new BigDecimal(collect.size()), 2, RoundingMode.HALF_DOWN).floatValue();
//            double c = (double) (Math.round(100*(double)i/collect.size())/100.0);
            alarmDbtMap.put(s, v);
        }

        homePageVo.setActionDistribution(actionDbtMap);
        homePageVo.setAlarmDistribution(alarmDbtMap);

        return CommonResponseVO.ok().data(homePageVo).message("首页饼状图+顶部统计！");
    }
}
