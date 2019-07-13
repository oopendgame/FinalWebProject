package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import WebPackage.chat.messageInfo;

class messageInfoTest {

	@Test
	void test() {
		//	public messageInfo(int id, int user1Id, int user2Id, String sms, String condition, String time) 
		int id = 1;
		int id1 = 2;
		int id2 = 3;
		String sms = "some sms";
		String condition = "sent";
		String time = "20:20";
		messageInfo info = new messageInfo(id, id1, id2, sms, condition, time);
		assertEquals(id, info.getId());
		assertEquals(id1, info.getUser1Id());
		assertEquals(id2, info.getUser2Id());
		assertEquals(sms, info.getSms());
		assertEquals(condition, info.getCondition());
		assertEquals(time, info.getTime());
	}

}
