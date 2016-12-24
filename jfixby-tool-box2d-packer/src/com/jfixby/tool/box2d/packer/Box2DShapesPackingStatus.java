package com.jfixby.tool.box2d.packer;

import com.jfixby.scarabei.api.collections.Collection;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;

public class Box2DShapesPackingStatus {
	
	private List<File> related_folders;

	public void setRelatedFolders(List<File> related_folders) {
		this.related_folders = related_folders;
	}

	public Box2DShapesPackingStatus() {

	}

	public Collection<File> getRelatedFolders() {
		return related_folders;
	}

}
