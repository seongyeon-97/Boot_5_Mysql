package com.sy.b5.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sy.b5.board.BoardVO;
import com.sy.b5.board.notice.NoticeMapper;
import com.sy.b5.interceptor.NoticeInterceptor;

@Component
public class TestSchedule {
	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Scheduled(cron = "*/30 * * * * *")
	public void cronScheduleTest() throws Exception{
		Calendar calendar = Calendar.getInstance();
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test");
		boardVO.setContents("contents");
		boardVO.setWriter("test");
		noticeMapper.setInsert(boardVO);
		System.out.println("Cron : " + calendar.getTime());
	}
	
	//@Scheduled(fixedRate = 2000, initialDelay = 2000)
	public void fixRateScheduleTest() throws Exception{
		Calendar calendar = Calendar.getInstance();
		Thread.sleep(3000);
		System.out.println("FixRate : " + calendar.getTime());
	}
	
	//@Scheduled(fixedDelay = 3000, initialDelay = 3000)
	public void fixDelayScheduleTest() throws Exception{
		Calendar calendar = Calendar.getInstance();
		System.out.println("FixDelay : " + calendar.getTime());
	}
	
}
