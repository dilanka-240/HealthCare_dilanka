package app.thivanka.healthcare.dto;

public class LoginDTO {

  private Long id;
  private String name;
  private String password;
  private String accessToken;
  private String refreshToken;

  // setters
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  // getters

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getRefreshTokne() {
    return refreshToken;
  }

}
