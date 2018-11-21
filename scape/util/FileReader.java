package scape.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
	private Path path;

	public FileReader(String path) {
		Path currentDir = Paths.get("");

		this.path = Paths.get(currentDir.toAbsolutePath().toString() + path);
	}

	public String getRawContents() throws IOException {
		return String.join("\n", Files.readAllLines(this.path));
	}

	public List<String> getLines() throws IOException {
		return Files.readAllLines(this.path);
	}
}
