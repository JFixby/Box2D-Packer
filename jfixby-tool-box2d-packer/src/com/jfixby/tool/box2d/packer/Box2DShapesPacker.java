package com.jfixby.tool.box2d.packer;

import java.io.IOException;

import org.box2d.r3.gdx.beditor.Box2DEditorShape;

import com.jfixby.r3.fokker.assets.Box2DEditorProject;
import com.jfixby.rana.api.pkg.StandardPackageFormats;
import com.jfixby.rana.api.pkg.fs.PackageDescriptor;
import com.jfixby.red.engine.core.resources.PackageUtils;
import com.jfixby.scarabei.api.assets.ID;
import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.log.L;

public class Box2DShapesPacker {

    public static Box2DShapesPackerSettings newSettings() {
	return new Box2DShapesPackerSettings();
    }

    public static void pack(Box2DShapesPackerSettings settings) throws IOException {

	File input_file = settings.getInputFile();
	L.d("Reading", input_file);

	Box2DEditorProject project = Box2DEditorProject.loadProject(input_file);

	List<ID> provisions = Collections.newList();
	for (int i = 0; i < project.size(); i++) {
	    Box2DEditorShape shape = project.getShape(i);
	    ID asset_id = (shape.getID());
	    L.d("    ", asset_id);
	    provisions.add(asset_id);
	}

	File output_folder = settings.getOutputFolder();

	File package_folder = output_folder.child(settings.getPackageName().toString());

	package_folder.makeFolder();
	File content = package_folder.child(PackageDescriptor.PACKAGE_CONTENT_FOLDER);
	content.makeFolder();

	content.getFileSystem().copyFileToFolder(input_file, content);

	L.d("writing", package_folder);

	PackageUtils.producePackageDescriptor(package_folder, StandardPackageFormats.Box2DEditor.Project, "1.0", provisions,
		Collections.newList(), input_file.getName());

    }

  
}
