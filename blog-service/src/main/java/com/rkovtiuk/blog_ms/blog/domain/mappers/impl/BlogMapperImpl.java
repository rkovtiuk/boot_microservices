package com.rkovtiuk.blog_ms.blog.domain.mappers.impl;

import com.rkovtiuk.blog_ms.blog.domain.mappers.BlogMapper;
import com.rkovtiuk.blog_ms.core.domain.entities.Blog;
import com.rkovtiuk.blog_ms.core.domain.models.BlogCategoryDTO;
import com.rkovtiuk.blog_ms.core.domain.models.BlogDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlogMapperImpl implements BlogMapper{

    @Override
    public List<BlogDTO> map(Page<Blog> pageableBlogs) {
        List<BlogDTO> blogs = new ArrayList<>();
        pageableBlogs.forEach(blog -> {
            BlogDTO dto = new BlogDTO();
            dto.setAuthorId(blog.getAuthor().getId());
            dto.setAuthorName(blog.getAuthor().getForename());
            dto.setId(blog.getId());
            dto.setDate(blog.getCreatedDate());
            BlogCategoryDTO categoryDTO = new BlogCategoryDTO();
            categoryDTO.setCategoryId(blog.getBlogCategory().getId());
            categoryDTO.setCategory(blog.getBlogCategory().getCategory());
            dto.setBlogCategoryDTO(categoryDTO);
        });
        return blogs;
    }
}
