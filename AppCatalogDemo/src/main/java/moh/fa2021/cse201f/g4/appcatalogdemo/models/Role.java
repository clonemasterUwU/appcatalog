package moh.fa2021.cse201f.g4.appcatalogdemo.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    STANDARD{
        @Override
        public String getAuthority() {
            return "STANDARD";
        }
    },
    MODERATOR{
        @Override
        public String getAuthority() {
            return "MODERATOR";
        }
    },
    ADMIN {
        @Override
        public String getAuthority() {
            return "ADMIN";
        }
    }
}
