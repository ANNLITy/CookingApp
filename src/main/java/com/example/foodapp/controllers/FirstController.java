package com.example.foodapp.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Первый контроллер")
public class FirstController {


    @GetMapping("/")
    @Operation(
    summary = "Страница с информацией о запуске"
    )
    public String start(){
        String startInfo ="Приложение запущено";
        StringUtils.isAllUpperCase(startInfo);
        return startInfo;
    }

    @GetMapping("/info")
    @Operation(
            summary = "Страница с информацией о сайте"
    )
    public String info(){
        return "Имя ученика: Анна Литяева  Проект:FoodApp Дата создания:02.02.2023 Описание:приложение для сайта рецептов";

    }
}
