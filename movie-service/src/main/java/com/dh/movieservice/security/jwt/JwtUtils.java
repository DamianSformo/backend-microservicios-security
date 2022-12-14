package com.dh.movieservice.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtUtils implements IJwtUtils {
    private String SECRET_KEY = "secret";

    @Override
	public String extractUsername (String token){ return extractClaim(token, Claims::getSubject);}
    @Override
	public Date extractExpiration(String token){ return extractClaim(token, Claims::getExpiration);}
    @Override
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    @Override
	public String getJwt(String token){
        String jwt = token.substring(7);
        return jwt;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){ return extractExpiration(token).before(new Date());}


    @Override
	public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    
	@Override
	public Long extractUserId(String token) {
		return Long.valueOf(extractAllClaims(token).get("userId").toString());
	}
}
