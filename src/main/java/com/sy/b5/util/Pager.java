package com.sy.b5.util;

import lombok.Data;

@Data
public class Pager {
	private String kind;
	private String search;
	
	//------------------------
	
	private Integer perPage; //한 페이지당 몇개 출력?
	private Integer pn; //현재 페이지 번호
	private Integer startRow; //시작 번호
	
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage();
	}
	
	public void makeNum(Long totalCount) { // db에서 받아온 totalCount를 매개변수로
		// 2. 총 페이지 갯수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount/this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 총 블럭의 갯수를 구하기
		Long perBlock = 5L; // 한 페이지에 5개씩 뿌려줄 예정
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
	}
	
	// ---------------- setter, getter ------------------------
	
	// pn이 null이거나 1미만일 경우를 대비해 두 경우 모두 1로 return 받기
	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;			
		}
		return pn;
	}
	// perPage가 null이거나 1미만일 경우를 대비해 두 경우 모두 10으로 return 받기
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;			
		}
		return perPage;
	}
	
	
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return this.search;
	}
}
