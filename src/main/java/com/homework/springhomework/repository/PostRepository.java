package com.homework.springhomework.repository;

import com.homework.springhomework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByModifiedAtDesc(); //전체목록

    Optional<Post> findById(Long id); //특정아이디로찾기
}
