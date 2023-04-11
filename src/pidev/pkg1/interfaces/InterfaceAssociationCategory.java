/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.pkg1.interfaces;

import pidev.pkg1.entities.Association;

import java.util.List;
import pidev.pkg1.entities.AssociationCategory;

public interface InterfaceAssociationCategory {
    public List<AssociationCategory> getAllAssociationCategories();
    public AssociationCategory getAssociationCategoryById(Integer id);
    public void addAssociationCategory(AssociationCategory associationCategory);
    public void updateAssociationCategory(AssociationCategory associationCategory);
    public void deleteAssociationCategory(Integer id);
}
