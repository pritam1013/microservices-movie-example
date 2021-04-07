package com.capg.movieinfo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capg.movieinfo.exception.DuplicateMovieException;
import com.capg.movieinfo.exception.MovieInfoErrorResponse;



@ControllerAdvice
@RestController
public class MoovieInfoErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateMovieException.class)
	public final ResponseEntity<MovieInfoErrorResponse> handleNotFoundException(Exception ex,WebRequest request){
		MovieInfoErrorResponse res=new MovieInfoErrorResponse(new Date(),ex.getLocalizedMessage(),request.getDescription(false));
		return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
	}
	
}


