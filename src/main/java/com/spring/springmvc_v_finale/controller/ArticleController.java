package com.spring.springmvc_v_finale.controller;

import com.spring.springmvc_v_finale.model.Article;
import com.spring.springmvc_v_finale.model.Category;
import com.spring.springmvc_v_finale.utils.Connex.Connexion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Controller
public class ArticleController {
    @GetMapping("/")
    public ModelAndView list() throws Exception {
        ModelAndView mod = new ModelAndView("list_article");
//        ArrayList<Article> list = new Article().SelectAll();
//        mod.addObject("list",list);
        return mod;
    }
    @GetMapping("/create")
    public ModelAndView toCreate() throws Exception {
        ModelAndView mod = new ModelAndView("create_article");
        ArrayList<Category> list = new Category().SelectAll();
        mod.addObject("list",list);
        return mod;
    }
    @PostMapping("/save")
    public ModelAndView saveArticle(HttpServletRequest req) throws Exception {
        int idcategory = Integer.parseInt(req.getParameter("idcategory"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String content = req.getParameter("content");
        Article article = new Article(idcategory,name,description,image,content);
        article.save();
        return list();
    }


    @GetMapping("/detail")
    @Cacheable("product")
    public ModelAndView detailArticle(@RequestParam("id") int idarticle) throws Exception {
        ModelAndView mod = new ModelAndView("detailarticle");
        mod.addObject("article",new Article().findById(Connexion.getConnection(), String.valueOf(idarticle)));
        return mod;
    }

    @GetMapping("/nouveau-create")
    public void handleRewrittenRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String forwardedUri = request.getRequestURI().replace("/nouveau-create", "/create");
        request.getRequestDispatcher(forwardedUri).forward(request, response);
    }

    @GetMapping(value = "/test.css", produces = "text/css")
    public ResponseEntity<Resource> getTestCss(HttpServletRequest request) throws Exception{
        Resource resource = new ClassPathResource("/static/test.css");
        long lastModified = resource.lastModified();
        if (request != null && request.getDateHeader("If-Modified-Since") == lastModified) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } else {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic())
                    .lastModified(lastModified)
                    .body(resource);
        }
    }

    @GetMapping("/versUpdate")
    public ModelAndView versUpdate(@RequestParam("id") int id) throws Exception {
        ModelAndView mod = new ModelAndView("UpdateArticle");
        ArrayList<Category> list = new Category().SelectAll();
        mod.addObject("list",list);
        mod.addObject("id",id);
        return mod;
    }

    @PostMapping("/Update")
    public ModelAndView Update(HttpServletRequest req) throws Exception {
        int idarticle = Integer.parseInt(req.getParameter("idarticle"));
        int idcategory = Integer.parseInt(req.getParameter("idcategory"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String image = req.getParameter("image");
        String content = req.getParameter("content");
        Article article = new Article(idcategory,name,description,image,content);
        article.update(idarticle);
        return list();
    }




}
