package com.spring.springmvc_v_finale.model;

import com.spring.springmvc_v_finale.utils.Connex.Connexion;
import com.spring.springmvc_v_finale.utils.DAO.ObjectBDD;
import com.spring.springmvc_v_finale.utils.inter.IdAnnotation;
import com.spring.springmvc_v_finale.utils.inter.KeyAnnotation;
import com.spring.springmvc_v_finale.utils.inter.TableAnnotation;

import java.util.ArrayList;

@TableAnnotation
public class Category extends ObjectBDD {
    @KeyAnnotation
    @IdAnnotation(name = "idcategory")
    private int idcategory;
    @KeyAnnotation
    private String name_category;

    public Category(int idcategory) {
        this.idcategory = idcategory;
    }

    public Category(String name_category) {
        this.name_category = name_category;
    }

    public Category() {
    }

    public Category(int idcategory, String name_category) {
        this.idcategory = idcategory;
        this.name_category = name_category;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
    public void save() throws Exception {
        super.saveAll(Connexion.getConnection());
    }
    public ArrayList<Category> SelectAll() throws Exception {
        return super.SelectAll(Connexion.getConnection());
    }
    public Category findById() throws Exception {
        return super.findById(Connexion.getConnection(),String.valueOf(getIdcategory()));
    }
    public ArrayList<Category> SelectAllByQuerry(String sql) throws Exception {
        return SelectAllByQuery(Connexion.getConnection(),sql);
    }
}
