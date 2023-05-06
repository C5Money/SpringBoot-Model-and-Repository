package com.example.thuisopdracht11springboottiemodelenrepository.exceptions;

public class RecordNotFoundException extends RuntimeException{
//    Instant Variables
    private static final long serialVersionUID = 1L;


//    Constructor
    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}

