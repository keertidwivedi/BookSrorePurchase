package org.store.com.ResponseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {

	private long CommentId;

	private String text;



	public CommentResponse(long commentId, String text) {
		super();
		CommentId = commentId;
		this.text = text;
	}

	

	@Override
	public String toString() {
		return "CommentResponse [CommentId=" + CommentId + ", text=" + text + "]";
	}

}
