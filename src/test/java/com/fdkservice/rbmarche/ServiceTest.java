package com.fdkservice.rbmarche;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdkservice.rbmarche.entity.Board;
import com.fdkservice.rbmarche.entity.Line;
import com.fdkservice.rbmarche.entity.Plan;
import com.fdkservice.rbmarche.entity.Shelve;
import com.fdkservice.rbmarche.entity.ShelveType;
import com.fdkservice.rbmarche.service.SetService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServiceTest {
	
	@Autowired
	private SetService setService;
	
	void deleteAll() {
		setService.deleteAllBoard();
		setService.deleteAllShelves();
		setService.deleteAllShelveType();
		setService.deleteAllLines();
		setService.deleteAllPlans();
	}
	
	void deleteAllExceptShelveType() {
		setService.deleteAllBoard();
		setService.deleteAllShelves();
		//setService.deleteAllShelveType();
		setService.deleteAllLines();
		setService.deleteAllPlans();
	}
	
	@Test
	@Order(1) 
	
	void testShelveType() {
		deleteAll();
		ShelveType st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(180);
		st.setWidth(100);
		st.setLength(150);
		st.setName("180");
		List<ShelveType> list = new ArrayList<ShelveType>();
		list.add(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(200);
		st.setWidth(100);
		st.setLength(150);
		st.setName("200");
		list.add(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(210);
		st.setWidth(100);
		st.setLength(150);
		st.setName("210");
		list.add(st);
		setService.saveShelveType(list);
		assertTrue(setService.getCountOfAllShelveType() == 3);
	}
	
	@Test
	@Order(2) 
	void testPlan() {
		Plan plan = new Plan();
		plan.setCreatedAt(new Date());
		plan.setName("TULLINS_INTER2");
		plan.setPathSize(2);
		plan = setService.savePlan(plan);
		assertTrue(setService.getAllPlans().size() == 1);
	}
	
	@Test
	@Order(3) 
	void testLine() {
		Plan plan = setService.getAllPlans().get(0);
		Line line = new Line();
		line.setCreatedAt(new Date());
		line.setPlan(plan);
		setService.saveLine(line);
		for(int i = 0;i < 8;i++) {
			line = new Line();
			line.setCreatedAt(new Date());
			line.setPlan(plan);
			setService.saveLine(line);
		}		
		assertTrue(setService.getAllLines().size() == 9);
	}
	
	@Test
	@Order(4) 
	void testShelve() {
		List<Line> lines = setService.getAllLines();
		List<ShelveType> shelveTypes = setService.getAllShelveTypes();
		Shelve shelve;
		for(int i = 0;i < lines.size();i++) {
			Line line = lines.get(i);
			for(int j = 0;j < 10;j++) {
				shelve = new Shelve();
				shelve.setLine(line);
				shelve.setCreatedAt(new Date());
				shelve.setShelveType(shelveTypes.get(j/4));
				setService.saveShelve(shelve);
			}			
		}		
		assertTrue(setService.getAllShelves().size() == 90);
	}
	
	@Test
	@Order(5)
	void testBoard() {
		List<Shelve> shelves = setService.getAllShelves();
		Board board;
		for(int i = 0;i < shelves.size();i++) {
			for(int j = 0;j < 6;j++) {
				board = new Board();
				board.setShelve(shelves.get(i));
				board.setCreatedAt(new Date());
				board.setFace((j%2==0)?"A":"B");
				board.setPosition(40*(j/2 + 1));
				setService.saveBoard(board);
			}
			
		}
		assertTrue(setService.getAllBoards().size() == setService.getAllShelves().size() * 6);
	}
	
	@Test
	@Order(6)
	void clear() {
		//deleteAllExceptShelveType();
	}
	
}
