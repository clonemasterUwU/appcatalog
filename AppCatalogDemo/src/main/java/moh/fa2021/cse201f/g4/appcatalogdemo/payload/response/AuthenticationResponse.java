package moh.fa2021.cse201f.g4.appcatalogdemo.payload.response;

public class AuthenticationResponse {
    public String getJwt() {
        return jwt;
    }

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
