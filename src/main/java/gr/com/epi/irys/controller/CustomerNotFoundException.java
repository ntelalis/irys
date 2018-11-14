package gr.com.epi.irys.controller;
public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	CustomerNotFoundException(Long id){
		super("Could not find customer " + id);
	}

}
