package com.dh.movieservice.security.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface IJwtUtils {

	String extractUsername(String token);

	Date extractExpiration(String token);

	<T> T extractClaim(
		String token,
		Function<Claims, T> claimsResolver);

	String getJwt(String token);

	String generateToken(UserDetails userDetails);

	Boolean validateToken(String token, UserDetails userDetails);

	Long extractUserId(String token);

}