/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.entities;


public class AssociationCategory {

    private Integer id;
    private String type;

    /** constructor */
    public AssociationCategory() {}
    public AssociationCategory(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
    public AssociationCategory(String type) {
        this.type = type;
    }

    /** getters and setters */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    /** toString */
    @Override
    public String toString() {
        return "AssociationCategory{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

}
