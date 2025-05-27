package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.category.CategoryRequest;
import com.FinansMate.FinansMate.dto.category.CategoryResponse;
import com.FinansMate.FinansMate.model.Category;
import com.FinansMate.FinansMate.model.MyUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T19:10:53+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponse toResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( category.getId() );
        categoryResponse.setName( category.getName() );
        categoryResponse.setCategory( category.getCategory() );

        return categoryResponse;
    }

    @Override
    public Category toEntity(CategoryRequest request, MyUser user) {
        if ( request == null && user == null ) {
            return null;
        }

        Category category = new Category();

        if ( request != null ) {
            category.setName( request.getName() );
            category.setCategory( request.getCategory() );
        }
        if ( user != null ) {
            category.setUser( user );
            category.setCreateAt( user.getCreateAt() );
            category.setUpdateAt( user.getUpdateAt() );
            category.setDeleted( user.getDeleted() );
            category.setId( user.getId() );
        }

        return category;
    }
}
