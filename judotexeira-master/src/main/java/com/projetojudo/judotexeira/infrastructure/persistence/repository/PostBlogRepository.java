package com.projetojudo.judotexeira.infrastructure.persistence.repository;

import com.projetojudo.judotexeira.infrastructure.persistence.entity.PostBlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostBlogRepository extends JpaRepository<PostBlogEntity, Long> {
}
