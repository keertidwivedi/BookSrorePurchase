package org.store.com.ResponseDto;

public class CommentResponse {
	
	private long CommentId;
	
	private String text;

	public long getCommentId() {
		return CommentId;
	}

	public void setCommentId(long commentId) {
		CommentId = commentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public CommentResponse(long commentId, String text) {
		super();
		CommentId = commentId;
		this.text = text;
	}

	public CommentResponse() {
		super();
	}

	@Override
	public String toString() {
		return "CommentResponse [CommentId=" + CommentId + ", text=" + text + "]";
	}

}
