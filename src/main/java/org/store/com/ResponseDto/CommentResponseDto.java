package org.store.com.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

	private long CommentId;

	private String text;

	

	@Override
	public String toString() {
		return "CommentResponse [CommentId=" + CommentId + ", text=" + text + "]";
	}

}
