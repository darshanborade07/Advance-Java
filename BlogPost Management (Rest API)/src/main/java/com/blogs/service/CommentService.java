package com.blogs.service;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommentDTO;

public interface CommentService {
	ApiResponse createNewComment(CommentDTO dto);
}
