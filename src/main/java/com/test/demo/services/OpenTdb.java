package com.test.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.test.demo.models.ApiResponse;
import com.test.demo.models.Quiz;
import com.test.demo.models.QuizResponse;
import com.test.demo.models.QuizResult;

@Service
public class OpenTdb {
	
	static String baseUrl = "https://opentdb.com/api.php?amount=5&category=";
	
	public QuizResponse getData() {
		QuizResponse qRes = new QuizResponse();
		
		ArrayList<Quiz> q = new ArrayList<Quiz>();
		
		for(int i = 11; i <= 12; i++) {
			ApiResponse res = getApiData(i);
			q.add(buildQuizData(res));
		}
		
		qRes.setQuiz(q);
		
		return qRes;
	}

	public ApiResponse getApiData(int category) {
		
		RestTemplate rt = new RestTemplate();

		String apiUrl = baseUrl + category;
		
		ApiResponse result = null;
		
		try {
			result = rt.getForObject(apiUrl, ApiResponse.class);
			
			//System.out.println(result.getResults()[0].getCategory());
		}
		catch(HttpClientErrorException e) {
			System.out.println("No data Found with the Category: " + category);
		}
		return result;
		
		
	}
	
	public Quiz buildQuizData(ApiResponse response) {
		Quiz q = new Quiz();
		
		q.setCategory(response.getResults().get(0).getCategory());
		
		ArrayList<QuizResult> qr = new ArrayList<QuizResult>();
		
		for(int i = 0; i < response.getResults().size(); i++) {
			QuizResult temp = new QuizResult();
			temp.setType(response.getResults().get(i).getType());
			temp.setDifficulty(response.getResults().get(i).getDifficulty());
			temp.setQuestion(response.getResults().get(i).getQuestion());
			temp.setAll_answers(response.getResults().get(i).getIncorrect_answers());
			temp.setCorrect_answer(response.getResults().get(i).getCorrect_answer());
			qr.add(temp);
		}
		q.setResults(qr);
		return q;
		
	}
	
}
