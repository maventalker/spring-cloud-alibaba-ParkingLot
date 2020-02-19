package com.mall.parking.base.gateway.jwt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Slf4j
public class JWTUtils {

	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	public static SecretKey generalKey(String stringKey) {
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}

	/**
	 * createJWT: 创建jwt<br/>
	 *
	 * @author guooo
	 * @param id        唯一id，uuid即可
	 * @param subject   json形式字符串或字符串，增加用户非敏感信息存储，如user tid，与token解析后进行对比，防止乱用
	 * @param ttlMillis 有效期
	 * @param stringKey
	 * @return jwt token
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static String createJWT(String id, String subject, long ttlMillis, String stringKey) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey(stringKey);
		JwtBuilder builder = Jwts.builder().setIssuer("").setId(id).setIssuedAt(now).setSubject(subject)
				.signWith(signatureAlgorithm, key);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * parseJWT: 解密jwt <br/>
	 *
	 * @author guooo
	 * @param jwt
	 * @param stringKey
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @since JDK 1.6
	 */
	public static Claims parseJWT(String jwt, String stringKey) throws ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {
		SecretKey key = generalKey(stringKey);
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		return claims;
	}

	public static boolean isTokenExpire(String jwt, String stringKey) {
		Claims aClaims = parseJWT(jwt, stringKey);
		// 当前时间与token失效时间比较
		if (LocalDateTime.now().isAfter(LocalDateTime.now()
				.with(aClaims.getExpiration().toInstant().atOffset(ZoneOffset.ofHours(8)).toLocalDateTime()))) {
			log.info("token is valide");
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			String key = "eyJqdGkiOiI1NGEzNmQ5MjhjYzE0MTY2YTk0MmQ5NTg4NGM2Y2JjMSIsImlhdCI6MTU3OTE2MDkwMiwic3ViIjoiMTIxMiIsImV4cCI6MTU3OTE2MDkyMn0";
			String token = createJWT(UUID.randomUUID().toString().replace("-", ""), "1212", 80000, key);
			System.out.println(token);
			parseJWT(token, key);
//            Thread.sleep(2500);
			Claims aClaims = parseJWT(token, key);
			System.out.println(aClaims.getExpiration());
			if (isTokenExpire(token, key)) {
				System.out.println("过期了");
			} else {
				System.out.println("normal");
			}
			System.out.println(aClaims.getSubject().substring(0, 2));

		} catch (ExpiredJwtException e) {
			System.out.println("又过期了");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
