package com.expensetracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.app.service.CategoryCreationService;

@RestController
@RequestMapping(value = "/create", method = RequestMethod.POST)
public class CreateCategoryController {
	@Autowired
	private CategoryCreationService categoryCreationService;

	@GetMapping("/{type}/{category}")
	public void createCategory(@PathVariable String type, @PathVariable String category) {
		categoryCreationService.createCategory(type, category);
	}
}
