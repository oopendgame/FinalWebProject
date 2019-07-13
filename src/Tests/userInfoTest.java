package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import WebPackage.user.userInfo;

class userInfoTest {

	@Test
	void test() {
		//public userInfo(int id, String userName, String name, String lastName, String img, String email, String birthday, String gender)
		int id = 1;
		String userName = "usName";
		String name = "nino";
		String lastName = "chanturia";
		String img = "someImg.jpg";
		String email = "nino@gmail.com";
		String birthday = "1998-11-09";
		String gender = "female";
		userInfo info = new userInfo(id, userName, name, lastName, img, email, birthday, gender);
		assertEquals(id, info.getId());
		assertEquals(userName, info.getUserName());
		assertEquals(name, info.getName());
		assertEquals(lastName, info.getLastName());
		assertEquals(img, info.getImg());
		assertEquals(email, info.getEmail());
		assertEquals(birthday, info.getBirthday());
		assertEquals(gender, info.getGender());
	}

}
