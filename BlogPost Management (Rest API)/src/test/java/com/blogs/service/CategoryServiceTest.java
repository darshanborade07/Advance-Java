package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.CategoryDTO;

@SpringBootTest //anno for the spring boot test framework to enable
//all spring beans including controller, service nd dao beans
class CategoryServiceTest {
	@Autowired
	private CategoryService categoryService;
	
	@Test
	void test() {
		assertNotNull(categoryService);
	}
	@Test
	void testGetAllCategories() {
		List<CategoryDTO> list = categoryService.getAllCategories();
		assertEquals(3, list.size());
		//not a good pattern i.e.Below one (should not display any resp from test case)
		list.forEach(System.out::println);
	}

}
