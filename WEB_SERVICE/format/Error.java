package com.example.gestion_flotte_avion_ws.format;

public class Error{
    private Exception error;

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public Error(Exception error) {
        this.error = error;
    }
}
