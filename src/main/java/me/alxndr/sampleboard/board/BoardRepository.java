package me.alxndr.sampleboard.board;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Alexander Choi
 * @date : 2021/08/03
 */
public interface BoardRepository extends JpaRepository<Board, Long> {

}
