package com.example.MOERADTEACHER.common.dropboxbean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DropboxMaster {
public Integer	dropboxId;
public String	dropboxType;

@JsonProperty(value="dropboxId", access=JsonProperty.Access.READ_ONLY)
public Integer getDropboxId() {
	return dropboxId;
}
@JsonProperty(value="dropbox_id", access=JsonProperty.Access.WRITE_ONLY)
public void setDropboxId(Integer dropboxId) {
	this.dropboxId = dropboxId;
}
@JsonProperty(value="dropboxType", access=JsonProperty.Access.READ_ONLY)
public String getDropboxType() {
	return dropboxType;
}
@JsonProperty(value="dropbox_type", access=JsonProperty.Access.WRITE_ONLY)
public void setDropboxType(String dropboxType) {
	this.dropboxType = dropboxType;
}


}
