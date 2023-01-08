package wane.kkuboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wane.kkuboard.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
