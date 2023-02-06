package com.example.foodapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping("/")
    public String start(){
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(){
        return "Имя ученика: Анна Литяева  Проект:FoodApp Дата создания:02.02.2023 Описание:приложение для сайта рецептов";

    }
}
