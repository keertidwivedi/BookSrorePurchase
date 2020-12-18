package org.store.com.RequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

	private String text;

	@Override
	public String toString() {
		return "CommentRequestDto [ text=" + text + "]";
	}

	public CommentRequestDto(String text) {
		super();
		this.text = text;
	}

}
