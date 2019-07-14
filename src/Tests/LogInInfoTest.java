package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import WebPackage.login.LogInInfo;
import WebPackage.user.userInfo;

class LogInInfoTest {

	@Test
	void test1() {
		int id = 1;
		int search = 2;
		int qId = 3;
		String userName = "mariami";
		
		LogInInfo info = new LogInInfo();
		info.setId(id);
		info.setUserName(userName);
		info.setSearchId(search);
		info.serQuizCreatorId(qId);
		
		assertEquals(id, info.getId());
		assertEquals(userName, info.getUserName());
		assertEquals(search, info.getSearchId());
		assertEquals(qId, info.getQuizCreatorId());
	}
	
	@Test
	void test2() {
		int id = 2222;
		int search = 33333;
		int qId = 444444;
		String userName = "saxeli";
		
		LogInInfo info = new LogInInfo();
		info.setId(id);
		info.setUserName(userName);
		info.setSearchId(search);
		info.serQuizCreatorId(qId);
		
		assertEquals(id, info.getId());
		assertEquals(userName, info.getUserName());
		assertEquals(search, info.getSearchId());
		assertEquals(qId, info.getQuizCreatorId());
	}
	
	@Test
	void test3Empty() {
		int id = 0;
		int search = 0;
		int qId = 0;
		String userName = "";
		
		LogInInfo info = new LogInInfo();
		info.setId(id);
		info.setUserName(userName);
		info.setSearchId(search);
		info.serQuizCreatorId(qId);
		
		assertEquals(id, info.getId());
		assertEquals(userName, info.getUserName());
		assertEquals(search, info.getSearchId());
		assertEquals(qId, info.getQuizCreatorId());
	}
	

}
