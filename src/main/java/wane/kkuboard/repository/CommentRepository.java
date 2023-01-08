package wane.kkuboard.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import wane.kkuboard.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByBoard_BoardIdx(@Param("boardIdx") Long boardIdx);
}
