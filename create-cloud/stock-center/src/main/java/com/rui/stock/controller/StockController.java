package com.rui.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create date 2022/5/27 14:05
 *
 * @author rui
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @RequestMapping("/add")
    public String add() {
        return "入库成功";
    }
}
