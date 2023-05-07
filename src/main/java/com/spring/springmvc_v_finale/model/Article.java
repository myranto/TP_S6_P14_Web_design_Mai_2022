package com.spring.springmvc_v_finale.model;

import com.spring.springmvc_v_finale.utils.Connex.Connexion;
import com.spring.springmvc_v_finale.utils.DAO.ObjectBDD;
import com.spring.springmvc_v_finale.utils.inter.ForeignKeyAnnotation;
import com.spring.springmvc_v_finale.utils.inter.IdAnnotation;
import com.spring.springmvc_v_finale.utils.inter.KeyAnnotation;
import com.spring.springmvc_v_finale.utils.inter.TableAnnotation;

import java.util.ArrayList;

@TableAnnotation
public class Article extends ObjectBDD {
    @KeyAnnotation
    @IdAnnotation(name = "idarticle")
    private int idarticle;
    @KeyAnnotation
    private int idcategory;
    @KeyAnnotation
    private String name;
    @KeyAnnotation
    private String description;
    @KeyAnnotation
    private String image;
    @KeyAnnotation
    private String content="";
    @ForeignKeyAnnotation(name = "idcategory",references = "idcategory")
    private Category category;


    public int getIdarticle() {
        return idarticle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(int idarticle, int idcategory, String name, String description, String image, String content) {
        this.idarticle = idarticle;
        this.idcategory = idcategory;
        this.name = name;
        this.description = description;
        this.image = image;
        this.content = content;
    }

    public Article(int idcategory, String name, String description, String image, String content) {
        this.idcategory = idcategory;
        this.name = name;
        this.description = description;
        this.image = image;
        this.content = content;
    }

    public Article(int idarticle) {
        this.idarticle = idarticle;
    }

    public Article() {
    }
    public void save() throws Exception {
        super.saveAll(Connexion.getConnection());
    }
    public ArrayList<Article> SelectAll() throws Exception {
        return super.SelectAll(Connexion.getConnection());
    }
    public Article findById() throws Exception {
        return super.findById(Connexion.getConnection(),String.valueOf(getIdcategory()));
    }
    public ArrayList<Article> SelectAllByQuerry(String sql) throws Exception {
        return SelectAllByQuery(Connexion.getConnection(),sql);
    }

    public void update(int id) throws Exception{
        setIdarticle(id);
        super.updateById(Connexion.getConnection());
    }

}
