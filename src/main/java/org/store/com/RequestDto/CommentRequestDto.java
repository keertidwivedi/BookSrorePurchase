package org.store.com.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

	private String text;

	@Override
	public String toString() {
		return "CommentRequestDto [ text=" + text + "]";
	}

	

}
