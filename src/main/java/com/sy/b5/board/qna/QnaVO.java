package com.sy.b5.board.qna;

import com.sy.b5.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
//hashcode mathod 충돌 가능성 있음
public class QnaVO extends BoardVO{
	private Integer ref;
	private Integer step;
	private Integer depth;
}
