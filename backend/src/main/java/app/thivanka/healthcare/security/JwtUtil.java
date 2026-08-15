package app.thivanka.healthcare.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

  private static final String SECRET = "your-256-bit-secret-your-256-bit-secret";
  private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

  private static final long ACCESS_EXPIRATION = 1000 * 60 * 15; // 15 min
  private static final long REFRESH_EXPIRATION = 1000 * 60 * 60 * 24 * 7; // 7 days

  public static String generateAccessToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public static String generateRefreshToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public static String validateToken(String token) {
    try {
      return Jwts.parserBuilder()
          .setSigningKey(key)
          .build()
          .parseClaimsJws(token)
          .getBody()
          .getSubject();
    } catch (JwtException e) {
      throw new IllegalArgumentException("Invalid JWT token");
    }
  }
}
