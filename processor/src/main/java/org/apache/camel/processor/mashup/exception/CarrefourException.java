package org.apache.camel.processor.mashup.exception;

public class CarrefourException extends IllegalStateException {

	private String idextractor;
	
	public CarrefourException(String id, String message) {
		super(message);
		idextractor=id;
	}

	public String getIdextractor() {
		return idextractor;
	}

	public void setIdextractor(String idextractor) {
		this.idextractor = idextractor;
	}
	

}
