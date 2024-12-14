package org.example.ecommerce.repository;

import org.example.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    public Category findByName(String name);

    @Query("SELECT c from Category c "+
            "WHERE :parent IS NULL OR c.parentCategory.name = :parent AND "+
            ":name IS NULL OR c.name = :name"
    ) 
    public Category findByParentAndName(@Param("parent") String parent, @Param("name") String name);
}
