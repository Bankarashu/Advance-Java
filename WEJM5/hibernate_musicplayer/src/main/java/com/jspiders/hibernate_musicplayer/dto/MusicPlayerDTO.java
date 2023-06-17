package com.jspiders.hibernate_musicplayer.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "music")
public class MusicPlayerDTO {
	@Id
	private int id;
	private String name;
	private String ablum;
	private String singer;
}
