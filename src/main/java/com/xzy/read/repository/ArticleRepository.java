package com.xzy.read.repository;

import com.xzy.read.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XieZhongYi
 * 2020/03/25 15:57
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByNotebookIdAndIsDeleted(Long notebookId, Boolean isDeleted);

    Article findByIsTop(Boolean isTop);

    List<Article> findAllByIsDeletedAndUserId(Boolean isDelete, Long userId);

    List<Article> findAllByUserIdAndIsPublished(Long userId, Boolean isPublished,Pageable pageable);

    List<Article> findAllByIdIn(List<Long> id);

    Page<Article> findAllByUserIdAndIsPublishedAndIsDeleted(Long userId, Boolean isPublished, Boolean isDelete, Pageable pageable);

    Page<Article> findAllByIsPublished(Boolean isPublished, Pageable pageable);

    @Query(value = "select count(*) from comment, reply where comment.article_id = :id and reply.article_id = :id",nativeQuery = true)
    Long countCommentsByArticleId(@Param("id")Long id);

    @Query(value = "select sum(words) from article where user_id = :id", nativeQuery = true)
    Long countWordsByUserId(@Param("id")Long id);

    @Query(value = "select sum(likes) from article where user_id = :id", nativeQuery = true)
    Long countLikesByUserId(@Param("id")Long id);

}
