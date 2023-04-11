/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.entities;


public class Association {

    private Integer id;
    private String nom;
    private String adresse;
    private String num_tel;
    private String mail;
    private String description;
    private Integer category_type_id;
    private String image;
    private Integer view_count;

    /** constructors */
    public Association() {
    }
    public Association(String nom, String adresse, String num_tel, String mail, String description, Integer category_type_id, String image, Integer view_count) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.mail = mail;
        this.description = description;
        this.category_type_id = category_type_id;
        this.image = image;
        this.view_count = view_count;
    }
    public Association(Integer id, String nom, String adresse, String num_tel, String mail, String description, Integer category_type_id, String image, Integer view_count) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.mail = mail;
        this.description = description;
        this.category_type_id = category_type_id;
        this.image = image;
        this.view_count = view_count;
    }

    /** getters and setters */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }
    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory_type_id() {
        return category_type_id;
    }
    public void setCategory_type_id(Integer category_type_id) {
        this.category_type_id = category_type_id;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Integer getView_count() {
        return view_count;
    }
    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", category_type_id=" + category_type_id +
                ", image='" + image + '\'' +
                ", view_count=" + view_count +
                '}';
    }
}

