package com.mike;


import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Spark.get(
                "/",
                (request, response) -> {
                    HashMap m = new HashMap();
                    m.put("name", "Mike");
                    return new ModelAndView(m, "home.html");
                },
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/login",
                (request, response) -> {
                    return new ModelAndView(null, "login.html");
                },
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/login",
                (request, response) -> {
                    response.redirect("/");
                    return null;
                }
        );
    }
}
