package com.RestAPI.model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FilenameUtils;

@Entity
@Table(name = "admin_user")
public class UserDetails {
	private String full_name;
	private String username;
	private String user_email;
	private String password;
	private String mobile_number;
	private String decodedPassword;
	private String role_name;
	private int status;
	private String userimage;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	private String userImageb64;
	private String state;
	private String zone;
	private String city;
	private String address;

	public UserDetails() {
		this.full_name = "";
		this.username = "";
		this.password = "";
		this.decodedPassword = "";
		this.user_email = "";
		this.role_name = "";
		this.status = 0;
		this.userimage = "";
		this.userID = 0;
		this.userImageb64 = "";
		this.mobile_number = "";
		this.state = "";
		this.city = "";
		this.zone = "";
		this.address = "";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.decodedPassword = password;
		Encoder encoder = Base64.getEncoder();
		this.password = encoder.encodeToString(password.getBytes());
	}

	public String getDecodedPassword() {
		return decodedPassword;
	}

	public void setDecodedPassword(String decodedPassword) {
		this.decodedPassword = decodedPassword;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserimage() {
		return userimage;
	}

	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserImageb64() {
		return userImageb64;
	}

	public void setUserImageb64(String userImageb64) {
		try {
			this.userImageb64 = "";
			if (userImageb64.equals(""))
				return;
			File candidatePhoto = new File(userImageb64);
			if (!candidatePhoto.isFile())
				return;
			String extension = FilenameUtils.getExtension(userImageb64);
			System.out.println(extension.toLowerCase());
			BufferedImage bImage = ImageIO.read(new File(userImageb64));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bImage, extension.toLowerCase(), baos);
			baos.flush();
			byte[] imageInByteArray = baos.toByteArray();
			baos.close();
			this.userImageb64 = DatatypeConverter.printBase64Binary(imageInByteArray);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			this.userImageb64 = "";
		}
	}

	

	@Override
	public String toString() {
		return "UserDetails [full_name=" + full_name + ", username=" + username + ", user_email=" + user_email
				+ ", password=" + password + ", mobile_number=" + mobile_number + ", decodedPassword=" + decodedPassword
				+ ", role_name=" + role_name + ", status=" + status + ", userimage=" + userimage + ", userID=" + userID
				+ ", userImageb64=" + userImageb64 + ", state=" + state + ", zone=" + zone + ", city=" + city
				+ ", address=" + address + "]";
	}

	public void decodePassword(String encodedPassword) {
		this.password = encodedPassword;
		Decoder decoder = Base64.getDecoder();
		this.decodedPassword = new String(decoder.decode(encodedPassword));
	}

}
