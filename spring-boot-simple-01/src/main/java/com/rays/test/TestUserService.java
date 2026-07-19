package com.rays.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testAdd() {
		
		UserDTO dto  = new UserDTO();
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLoginId("abc@gmail.com");
		dto.setPassword("abc@123");
		
		long pk = userService.add(dto);
		
		dto = userService.get(pk);
		
		assertNotNull("data added"+dto);
		
		
	}
	
	@Test
	public void update() {
		
		UserDTO dto  =new UserDTO();
		
		dto.setId(1L);
		dto.setPassword("123");
		
		userService.update(dto);
		
		dto = userService.get(1);
		
		assertNotNull("123" +dto.getPassword());
		
	}
	
	@Test
	public void testDelete() {

		userService.delete(1L);

		UserDTO dto = userService.get(1);

		assertNull("data deleted", dto);
	}

}
