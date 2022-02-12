package me.juni.angelpods.find;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.juni.angelpods.find.dto.FindCreateDto;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTest {

	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;
	
	@DisplayName("습득물 등록 - 입력값 정상")
	@Test
	void createFind() throws Exception {
		FindCreateDto dto = new FindCreateDto();
		dto.setUserId("honggildong");
		dto.setmCategory("무선이어폰");
		dto.setsCategory("에어팟");
		dto.setLat("110.204252");
		dto.setLng("120.255655");
		dto.setTitle("무학여고 앞에서 찾았습니다.");
		dto.setDesc("에어팟 무학여고 앞에 버스정류장에 있었어요");
		dto.setiName("에어팟 3세대");
		dto.setGetTime(LocalDateTime.of(2022, 02, 12, 12, 14));
		dto.setGetLoc("서울시 성동구 응봉동 360-1");
		dto.setPhone("010-1234-5678");
		mockMvc.perform(post("/api/find")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto)))
		.andDo(print())
		.andExpect(status().isCreated());
	}
}