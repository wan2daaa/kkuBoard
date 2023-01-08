package wane.kkuboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wane.kkuboard.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Transactional
    @Modifying
    @Query("update Board set boardViews = boardViews + 1 where boardIdx = :boardIdx")
    void updateView(@Param(value = "boardIdx") Long boardIdx);

}
